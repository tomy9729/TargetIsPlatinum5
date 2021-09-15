package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1912 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N+1];
		long[] dp = new long[N+1];
		for(int i=1;i<N+1;i++) {
			dp[i] = arr[i] =  Integer.parseInt(st.nextToken());
		}
		
		//Arrays.fill(dp, Integer.MIN_VALUE);
		//[0, 10, 6, 9, 10, 15, 21, 0, 12, 33, 32]
		//dp[1] = arr[1];
		out : for(int i=2;i<N+1;i++) {
			for(int j=i-1;j<N;j++) {
				if(dp[j+1] >= dp[j] + arr[j+1]) 
					continue out;
				// dp[j] + arr[j+1] 값이 클 때만 다음으로 진행 
				else
					dp[j+1] = dp[j] + arr[j+1];
				
			}
			
	
		}
		long max = Integer.MIN_VALUE;
		for(int i=1;i<=N;i++) {
			if(dp[i] > max) max=dp[i];
		}
		
		System.out.println(max);
	}

}
