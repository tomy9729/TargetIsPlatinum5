package week06;

import java.util.Scanner;

public class BOJ_2193 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		//System.out.println(N);
		long[] dp = new long[N+1];
		dp[0] = 0;
		dp[1] = 1;		
		int i = 2;
		while(i<=N) {
			dp[i] = dp[i-1]+ dp[i-2];
			i++;
		}
		
		System.out.println((long)dp[N]);
		
	}

}
