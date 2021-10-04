package week7.day0826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ_2346 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static Deque<int[]> DQ;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		DQ = new ArrayDeque<>();
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			DQ.add(new int[] {i+1,Integer.parseInt(st.nextToken())});
		}
		
		int cur[] = DQ.poll();
		sb.append(cur[0]+" ");
		while(!DQ.isEmpty()) {
			
			if(cur[1] > 0) {
				int t = cur[1];
				for(int i=0; i<t; i++) {
					cur = DQ.pollFirst();
					
					if(i==t-1) {
						
						break;
					}
					DQ.addLast(cur);
				}
			}else if(cur[1]<0) {
				int t = cur[1];
				t = Math.abs(t);
				for(int i=0; i<t; i++) {
					cur = DQ.pollLast();
					
					if(i==t-1) {
						
						break;
					}
					DQ.addFirst(cur);
				}
			}
			sb.append(cur[0]+" ");
			
		}
		System.out.println(sb.toString());
	}

}
