//9372번 상근이의 여행.java
package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 상근이의_여행_9372 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws NumberFormatException, IOException {
    	int T = Integer.parseInt(br.readLine());
    	
    	for(int t=1;t<=T;t++) {
    		st = new StringTokenizer(br.readLine()," ");
    		int N = Integer.parseInt(st.nextToken());
    		int M = Integer.parseInt(st.nextToken());
    		
    		List<ArrayList<Integer>> graph = new ArrayList<>();
    		for(int i=0;i<=N;i++) {
    			graph.add(new ArrayList<Integer>());
    		}
    		for(int i=0;i<M;i++) {
    			st = new StringTokenizer(br.readLine()," ");
    		}
    		
    		sb.append((N-1)+"\n");
    	}
    	System.out.println(sb.toString());
	}
}
