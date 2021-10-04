package week10.day0915;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2293 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,K;
	static int[] coins;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		coins = new int[N+1];//동전의 개수
		for(int i=1; i<=N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		System.out.println(dp());
	}

	private static int dp() {
		int[][] DP = new int[N+1][K+1];
		
		for(int i=0; i<=N; i++) {
			DP[i][0] = 1;//동전을 안 쓰는 방법 한 가지
		}
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=K; j++) {
				
				if(j-coins[i]>=0) {
					DP[i][j] = DP[i-1][j] + DP[i][j-coins[i]];
				}
				else {
					DP[i][j] = DP[i-1][j];
				}
			}
		}
		
		return DP[N][K];
	}

}
