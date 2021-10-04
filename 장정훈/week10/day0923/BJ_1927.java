package week11.day0923;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1927 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static PriorityQueue<Integer> PQ = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num != 0) {//0이 아닐 때는 넣고
				PQ.add(num);
			}else {//0일때는 큐에서 작은 값 빼거나 없으면 0이 출력하라고 함.
				if(PQ.isEmpty()) {
					sb.append("0\n");
				}else {
					sb.append(PQ.poll()+"\n");
				}
			}
		}
		System.out.println(sb.toString());
	}

}
