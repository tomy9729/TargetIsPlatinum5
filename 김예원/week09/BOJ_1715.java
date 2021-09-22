package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1715 {

	static int N;
	static PriorityQueue<Long> q = new PriorityQueue<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			long a = Integer.parseInt(br.readLine());
			q.offer(a);
		}
		
		long sum=0;

		

		while(q.size()>1) {
			long i = q.poll();
			long j = q.poll();
			
			sum += (i+j);
			if(!q.isEmpty()) {
				q.offer(i+j);
			}
		}	
	
			
		
			

		
		
		System.out.println(sum);
		
		
	}

}
