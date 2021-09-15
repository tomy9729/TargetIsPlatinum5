package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10844 {

	// 26~30line 더할 때부터 나누어 주어야 long의 범위를 넘지 않는다
	static long div = 1000000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		long[][] dp = new long[n][10];
		
		dp[0][0] = 0;
		for(int i=1;i<10;i++) {
			dp[0][i] = 1; 
		}
		
		if(n>=2) {
			for(int row=1;row<n;row++) {
				for(int i=0;i<10;i++) {
					if(i==0) dp[row][i] = dp[row-1][i+1]%div;
					else if(i==9) dp[row][i] = dp[row-1][i-1]%div;
					else dp[row][i] =  dp[row-1][i+1]%div+ dp[row-1][i-1]%div;
				}
			}
		}

		long sum=0;
		for(int i=0;i<10;i++) {
			sum += dp[n-1][i];
		}
		sum %=div;
		System.out.println(sum);
		
		

	}

}
