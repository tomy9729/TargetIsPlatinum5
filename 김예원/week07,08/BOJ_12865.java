package week07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_12865 {

	static int N, K;
	static int[] dp ;	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 배낭의 개수
		N = Integer.parseInt(st.nextToken());
		// 최대 수용 가능한 무게
		K = Integer.parseInt(st.nextToken());
		
		dp = new int[K+1];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			// 무게
			int w = Integer.parseInt(st.nextToken());
			// 가치
			int v = Integer.parseInt(st.nextToken());
			
			for(int k=K;k>=w;k--) {
				if((dp[k-w] + v) > dp[k]) {
					dp[k] = dp[k-w] + v;
				}
			}

		}
		int result = Arrays.stream(dp).max().getAsInt();
		
		System.out.println(result);
		
	}

}
