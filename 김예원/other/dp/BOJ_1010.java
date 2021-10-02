package week06.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1010 {
	
	static int t, N, M, count;
	// dp 배열 :(문제 조건) N,M이 최대 30
	static int[][] dp = new int[30][30];
	public static void main(String[] args) throws NumberFormatException, IOException {

		/*  Idea : 조합을 만드는 문제 
			조건 : 숫자가 0<= n,r<=30 (시간과 효율 고려)
			
		+ dp 배열[]
			
		
		*/
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int T=0 ; T<t;T++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			count = 0;
			
			N = Math.min(N,(M-N));

		
			for(int i=0;i<30;i++) {
				dp[i][i] = 1;
				dp[i][0] = 1;
			}
			
			
			// 반복문 사용
			// 반복문을 사용하는 초기 작업은 2C1이어야 함
			// 2C1 = 1C1 + 1C0 
			
			for(int i=2;i<30;i++) {
				for(int j=1;j<30;j++) {
					dp[i][j] =dp[i-1][j]+dp[i-1][j-1]; 
					
				}
			}
			
			
			
			//com(M,N);
			// M-N+1 번  
			System.out.println(dp[M][N]);
			
		}
				
		
	}
	
	/*private static int com(int m, int n) {
		// 끝
		if(dp[m][n]>0) {
			return dp[m][n];
		}
		
		if(m==n || n==0) {
			return dp[m][n] = 1;
		}
		
		return dp[m][n] =  com(m-1,n) + com(m-1,n-1);
	}*/
	

}
