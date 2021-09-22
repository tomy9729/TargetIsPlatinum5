package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_14235 {

	static int n;
	static PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			if(a==0) {
				if(q.isEmpty()) 
					sb.append(-1).append("\n");
				else 
					sb.append(q.poll()).append("\n");
				
			}else {
				for(int j=0;j<a;j++) {
					q.offer(Integer.parseInt(st.nextToken()));
				}
			}

		}
		
		System.out.println(sb.toString());
		
	}

}
