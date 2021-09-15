package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1932 {

	static int n;
	static int[][] arr, dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n+2][n+2];
		dp = new int[n+2][n+2];
		for(int i=1;i<=n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=i;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=n;i>0;i--) {
			for(int j=1;j<=n;j++) {
				dp[i][j] = Math.max(dp[i+1][j], dp[i+1][j+1]) + arr[i][j];				
			}
			
		}
		
		
		System.out.println(dp[1][1]);
		
	}

}
