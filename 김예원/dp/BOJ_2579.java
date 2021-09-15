package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2579 {

	static int N;
	static int[] arr, dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		dp = new int[N+1];
		
		for(int i=1;i<N+1;i++) {
			arr[i] = Integer.parseInt(br.readLine());	
		}
		
		dp[0] = 0;
		dp[1] = arr[1];
		
		if(N>=2) {
			dp[2] = arr[2] + arr[1];
		}
		
		
		for(int i=3;i<N+1;i++) {
			dp[i] = Math.max(dp[i-2], dp[i-3]+ arr[i-1]) + arr[i];
		}
		
		
		//System.out.println(Arrays.toString(dp));
		System.out.println(dp[N]);

	}

}
