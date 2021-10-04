package week11.day0923;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_11279 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static PriorityQueue<Integer> PQ = new PriorityQueue<>((x, y) -> Integer.compare(y, x));
	//최대로 정렬할 때는 저장 조건을 람다식으로 지정. //다른 방법 : (x, y) -> y - x
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num != 0) {//0이 아닐 때는 넣고
				PQ.add(num);
			}else {//0일때는 큐에서 큰 값 빼거나 없으면 0이 출력하라고 함.
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
