package week14.day1014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_9465 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int Max;
	static int N;
	static int[][] map;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			Max = 0;
			N = Integer.parseInt(br.readLine());
			map = new int[2][N+1];
			dp = new int[2][N+1];
			for(int i=0; i<2; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=1; j<=N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
//			dp[0][0], dp[1][0]은 초기화를 위해 0
			dp[0][1] = map[0][1];
			dp[1][1] = map[1][1];
			
//			for(int i=0; i<2; i++) {
//				for(int j=2; j<=N; j++) {
//					dp[i][j] = Math.max(dp[(i+1)%2][j-1], dp[(i+1)%2][j-2])+map[i][j];
//				}
//			}
			//DP 값을 서로 교차해서 쓰기 때문에 한 번에 구해야 한다.
			for(int j=2; j<=N; j++) {
				dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2])+map[0][j];
				dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2])+map[1][j];
			}
			Max = Math.max(dp[0][N], dp[1][N]);
			sb.append(Max+"\n");
		}
		System.out.println(sb.toString());
	}
	
}
