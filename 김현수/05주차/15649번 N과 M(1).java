//15649번 N과 M(1).java
package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과_M1_15649 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int N;
    static int M;
    static boolean[] isSelected;
    static int[] select;
    
    public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		isSelected = new boolean[N];
		select = new int[M];
		P(0);
		System.out.println(sb.toString());
	}
    
    public static void P(int count) {
    	if(count==M) {
    		for(int i=0;i<M;i++) {
    			sb.append(select[i]+" ");
    		}sb.append("\n");
    		return ;
    	}
    	for(int i=0;i<N;i++) {
    		if(!isSelected[i]) {
    			isSelected[i]=true;
    			select[count] = i+1;
    			P(count+1);
    			isSelected[i]=false;
    		}
    	}
    }
}
