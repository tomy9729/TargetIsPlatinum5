package week13.day1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_18442 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int V, P;
	static long L;
	static long[] local;
	static long[] post;
	static long[] extra;
	static long min;

	public static void main(String[] args) throws IOException {
		// 18442 우체국 1번의 문제는 최대 경우의 수가 20개의 마을 중 10개의 마을에 우체국을 설치하는 경우가 가장 많은 경우의 수인데
		// 이 20C10은 184756밖에 안 되므로 2차원 배열과 조합으로 풀 수 있는 문제.
		// 18443 우체국 3번의 문제는 최대 경우의 수가 100개 마을 중 50개의 마을에 우체국을 설치하는 경우가 가장 많은 경우의 수이므로
		// DP를 사용해야만 풀 수 있는 문제이다.
		// 시험에서는 L의 범위는 1000까지였고 V의 범위는 100까지였음을 감안하면 우체국 2를 풀 수 있으면 정답으로 간주할 수 있다.
		// DP를 이용하기 전 문제 이해를 돕기 위한 2차원 배열 풀이.
		st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		L = Long.parseLong(st.nextToken());
		post = new long[P]; // 뽑을 개수로 만듦.
		extra = new long[P]; // 뽑을 개수로 만듦.
		local = new long[V]; // 집의 위치를 저장.
		min = Long.MAX_VALUE;

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < V; i++) {
			local[i] = Long.parseLong(st.nextToken());
		}

		combi(0, 0);

		sb.append(min + "\n");
		for (int i = 0; i < P; i++) {
			sb.append(post[i] + " ");
		}
		System.out.println(sb.toString());
	}

	private static void combi(int cnt, int idx) {// cnt는 뽑은 개수, idx는 시작하는 위치
		if (cnt == P) {// 기저조건!
			// 뭔가를 할 예정.
//			System.out.println(Arrays.toString(post));
			play();
			return;
		}
		for (int i = idx; i < V; i++) {
			extra[cnt] = local[i];
			combi(cnt + 1, i + 1);
		}

	}

	private static void play() {
		long sum = 0;
		for (int i = 0; i < V; i++) {
			long semi = Long.MAX_VALUE;
			for (int j = 0; j < P; j++) {
				
				semi = Math.min(semi, Math.min(Math.abs(local[i] - extra[j]), L - Math.abs(local[i] - extra[j])));
				
			}
			sum += semi;
		}
		if (min > sum) {
			min = sum;
			for (int i = 0; i < P; i++) {
				post[i] = extra[i];
			}
		}

	}

//	private static void play() {
//		int semi = 0;
//
//		for (int i = 0; i < V; i++) {
//			long semiMin = Long.MAX_VALUE;
//			boolean flag = true;
//			for (int j = 0; j < P; j++) {
//				if(local[i] == local[extra[j]]) {
//					flag = false;
//					break;
//				}
//				semiMin = Math.min(semiMin,
//						Math.min(Math.abs(local[i] - local[extra[j]]), L - Math.abs(local[i] - local[extra[j]])));
//			}
//			if(flag) {
//				semi += semiMin;
//			}
//		}
//		if (min > semi) {
//			min = semi;
//			for (int i = 0; i < P; i++) {
//				post[i] = local[extra[i]];
//			}
//		}
//	}
}
