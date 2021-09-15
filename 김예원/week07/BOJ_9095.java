package week07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095 {
	static int T;
	static int dp[] = new int[11];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i=4;i<11;i++) {
			dp[i]= dp[i-1]+dp[i-2]+dp[i-3];
		}
		
		for(int i=0;i<T;i++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(dp[n]);
		}
		
		
		
	}
}
