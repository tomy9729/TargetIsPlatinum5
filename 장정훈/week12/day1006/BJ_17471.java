package week13.day1006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17471 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;// 마을의 수
	static int[] population;// 마을 당 인구 수
	static List<Integer>[] relation;// 인접관계
	static int Min;
	static int size;
	static int target;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		population = new int[N + 1];
		relation = new ArrayList[N + 1];
		target = (int) (Math.pow(2, N)/2);
		for (int i = 1; i <= N; i++) {
			relation[i] = new ArrayList<>();
		}
		Min = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
			
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				int near = Integer.parseInt(st.nextToken());
				relation[i].add(near);
			}
		}
		
		powerSetDupPer(N, new boolean[N + 1]);
		if (Min == Integer.MAX_VALUE) {
			Min = -1;
		}
		System.out.println(Min);

	}

	private static void solve(boolean[] choosed) {

		if (play(choosed)) {
			// 만약 부분집합으로 꺼내어진 애들이 연결되어있다면
			int N1 = 0;
			boolean[] newChoosed = new boolean[N + 1];
			for (int i = 1; i <= N; i++) {
				if (choosed[i]) {
					N1 += population[i];
				} else {
					newChoosed[i] = true;
				}
			}
			if (play(newChoosed)) {
				int N2 = 0;
				for (int i = 1; i <= N; i++) {
					if (newChoosed[i]) {
						N2 += population[i];
					}
				}
				Min = Math.min(Min, Math.abs(N1 - N2));
			}
		}

	}

	private static boolean play(boolean[] v) {

		boolean flag = true;
		boolean[] checked = new boolean[N + 1];
		Queue<Integer> Q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (v[i]) {
				Q.offer(i);
				checked[i] = true;
				break;
			}
		}
		while(!Q.isEmpty()) {
			int next = Q.poll();
			for(int i=0; i<relation[next].size(); i++) {
				if(v[relation[next].get(i)] && !checked[relation[next].get(i)]) {
					checked[relation[next].get(i)] = true;
					Q.offer(relation[next].get(i));
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			if (v[i]) {
				if (!checked[i]) {
					return false;
				}
			}
		}

		return true;

	}

	private static void powerSetDupPer(int toChoose, boolean[] choosed) {
		if(size == target) {
			return;
		}
		if (toChoose == 0) {
//        	System.out.println(Arrays.toString(choosed));
			size++;
			solve(choosed);
			return;
		}
		choosed[toChoose] = true; // 처음에는 다 true로 진행하고
		powerSetDupPer(toChoose - 1, choosed); // true로 넣어준 다음에
		choosed[toChoose] = false; // 다음에는 false로 바꿔서 진행하면 모든 경우의 수를 볼 수 있겠다!
		powerSetDupPer(toChoose - 1, choosed);
	}

}
