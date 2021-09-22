package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1927 {

	/**
	 * 최소힙(우선순위 큐)
	 */
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			if(num!=0) {
				q.offer(num);
			}else {
				if(q.isEmpty()) {
					sb.append(0).append("\n");
				}else if(num==0 && !q.isEmpty()){
					sb.append(q.poll()).append("\n");					
				}
					
			}
		}
		System.out.println(sb.toString());

	}

}
