package week11.day0923;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1715 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static PriorityQueue<Integer> pq;

	public static void main(String[] args) throws IOException {
		pq = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		// 작은 카드 묶음을 기준으로 비교하면 최소가 된다.
		// 작은 거 두개 빼서 더하고 더한 값 add
		int result = 0;
		if (N != 1) {
			while (true) {
				int semi = 0;
				semi += pq.poll();
				semi += pq.poll();
				result += semi;
				if (pq.isEmpty()) {
					break;
				}
				pq.add(semi);
			}
		}
		System.out.println(result);

	}
}
