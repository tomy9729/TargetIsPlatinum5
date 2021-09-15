package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BOJ_15486 {

	static int N, max;
	static int[] T, P, dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		T = new int[N + 2];
		P = new int[N + 2];
		dp = new int[N + 2];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < N + 2; i++) {
			/*max의 역할이 중요함 
			지금까지 최대 수익을 저장하는 변수*/
			
			if (max < dp[i])
				max = dp[i];

			int day = i + T[i];
			if (day < N + 2)
				dp[day] = Math.max(max + P[i], dp[day]);

		}


		System.out.println(max);

	}

}
