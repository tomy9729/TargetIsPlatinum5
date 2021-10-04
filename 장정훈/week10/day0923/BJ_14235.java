package week11.day0923;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_14235 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static PriorityQueue<Integer> pq;
	static int N;
	
	public static void main(String[] args) throws IOException {
		pq = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
		N = Integer.parseInt(br.readLine());
		for(int t=0; t<N; t++) {
			st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken());
			if(n == 0) {
				if(pq.isEmpty()) {
					sb.append("-1\n");
				}else {
					sb.append(pq.poll()+"\n");
				}
			}else {
				for(int i=0; i<n; i++) {
					pq.add(Integer.parseInt(st.nextToken()));
				}
			}
		}
		System.out.println(sb.toString());
	}
}
