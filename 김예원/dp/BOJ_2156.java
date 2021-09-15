package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2156 {

	static int N;
	static long[] arr, dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		
		arr = new long[N+1];
		dp = new long[N+1];
		for(int i=1;i<=N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dp[1] = arr[1];
		if(N>=2) {
			dp[2] = arr[1]+arr[2];
		}
		
		for(int i=3;i<=N;i++) {
			// 겉 : 해당 위치의 포도주를 안마시는 경우, 마시는 경우를 비교 
			dp[i] = Math.max(dp[i-1],Math.max(dp[i-2] +  arr[i], dp[i-3]+arr[i-1] +  arr[i]));
		}
		System.out.println(Arrays.toString(dp));
		System.out.println(Arrays.stream(dp).max().getAsLong());
	}

}
