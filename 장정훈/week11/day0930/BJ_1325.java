package week12.day0930;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1325 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static List<Integer>[] listAry;
	static int N, M;
	static boolean[] trust;
	static int[] cntAry;
	static int maxCnt;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		listAry = new ArrayList[N + 1];
		cntAry = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			listAry[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			// B를 해킹하면 A도 해킹할 수 있다.
			listAry[A].add(B);
			// A에 들어갈 수 있는 경로를 추가
		}
		
		for (int i = 1; i <= N; i++) {
			trust = new boolean[N + 1];
			play(i);
		}
		
		for(int i=1; i<=N; i++) {
			maxCnt = Math.max(maxCnt, cntAry[i]);
		}

		for (int i = 1; i < N + 1; i++) {
			if (cntAry[i] == maxCnt) {
				sb.append(i + " ");
			}
		}
		System.out.println(sb);
	}

	private static void play(int idx) {

		Queue<Integer> Q = new LinkedList<>();

		Q.offer(idx);
		trust[idx] = true;

		while (!Q.isEmpty()) {
			int pollNum = Q.poll();
			for (int i = 0; i < listAry[pollNum].size(); i++) {
				int tmp = listAry[pollNum].get(i);//신뢰할 수 있는 컴퓨터
				if (trust[tmp]) {
					continue;
				}
				Q.offer(tmp);
				trust[tmp] = true;
				cntAry[tmp]++;
			}

		}

	}

}
