package algol;

import java.awt.print.Book;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class SevenDwarf_2309 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        //입력
        int[] arr = new int[9];
        boolean[] bool = new boolean[7];
        for(int i=0;i<9;i++) {
        	arr[i] =Integer.parseInt(br.readLine()); 
        }
		
        // 키의 합이 100인 7명 구하는 logic
        
        int r = 7; 
        Combination comb = new Combination(arr.length, r); 
        comb.combination(arr, 0, 0, 0); 
        ArrayList<ArrayList<Integer>> result = comb.getResult(); 
        //System.out.println("모든 조합의 수: " + result.size()); 
        Collections.sort(result.get(0));
        

        // 출력
        for(int i=0;i<7;i++) {
        	bw.write(result.get(0).get(i) + "\n");       	  
       }
      
		bw.flush();
        bw.close();
        
	}
	
}

/*조합*/
class Combination { 
	private int n; 
	private int r; 
	private int[] now; 
	// 현재 조합 
	private ArrayList<ArrayList<Integer>> result; 
	// 모든 조합
	
	public ArrayList<ArrayList<Integer>> getResult() { return result; } 
	
	public Combination(int n, int r) { this.n = n; this.r = r; this.now = new int[r]; this.result = new ArrayList<ArrayList<Integer>>(); }
	
	public void combination(int[] arr, int depth, int index, int target) { 
		if (depth == r) { 
			ArrayList<Integer> temp = new ArrayList<>(); 
			for (int i = 0; i < now.length; i++) { 
				temp.add(arr[now[i]]); 
			} 
			if(temp.stream().mapToInt(Integer::intValue).sum()==100)
				result.add(temp); 
			return; 
		} 
		if (target == n) 
			return; 
		now[index] = target; 
		combination(arr, depth + 1, index + 1, target + 1); 
		combination(arr, depth, index, target + 1); 
		} 
	}

