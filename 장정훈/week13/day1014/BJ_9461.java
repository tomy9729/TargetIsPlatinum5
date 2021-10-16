package week14.day1014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_9461 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static long[] dp;//값 초과
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		dp = new long[101];
		dp[1] = dp[2] = dp[3] = 1;
		dp[4] = 2;
		
		for(int i=5; i<=100; i++) {
			dp[i] = dp[i-3] + dp[i-2];
		}
		
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine());
			
			sb.append(dp[N]+"\n");
		}
		System.out.println(sb.toString());
	}
}
