package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11722 {
	static int[] arr;
	static int[] dp;
	static int A;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		A = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[A];
		dp = new int[A];
		
		//Arrays.fill(dp, -1);
		for(int i=0;i<A;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=A-1;i>=0;i--) {
			LIS(i);
		}
		
		int max = -1;
		for(int i=0;i<A;i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
		
	}
	private static int LIS(int N) {
		// 탐색하지 않았던 위치의 경우
		if(dp[N]==0) {
			dp[N]=1; // 1로 초기화
			
			for(int i=N;i<A;i++) {
				if(arr[N] > arr[i]) {
					dp[N] = Math.max(dp[N], LIS(i)+1);
				}
			}
		}
		

		return dp[N];
		
	}
	
}
