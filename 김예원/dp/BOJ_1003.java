package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1003 {

	static int T;
	static int[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		dp = new int[41][2];
		
		// f(0)
		dp[0][0] = 1;
		dp[0][1] = 0;
		// f(1)
		dp[1][0] = 0;
		dp[1][1] = 1;
		for(int i=2;i<=40;i++) {
			dp[i][0] = dp[i-1][0] +dp[i-2][0];
			dp[i][1] = dp[i-1][1] +dp[i-2][1];
		}
		
		for(int i=0;i<T;i++) {
			int N = Integer.parseInt(br.readLine());
			
			System.out.println(dp[N][0]+" "+dp[N][1]);
			
		}
		
		

	}

}
