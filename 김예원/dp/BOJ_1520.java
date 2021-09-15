package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1520 {
	static int N, M;
	static long[][] arr;
	static long[][] dp;
	static int[][] dir= {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new long[N][M];
		dp = new long[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());	
			}
		}

		for(long[] a : dp) {
			Arrays.fill(a, -1);
		}
		
		System.out.println(find(0,0));
		
		for(long[] a: dp ) {
			System.out.println(Arrays.toString(a));
		}
	}
	private static long find(int r, int c) {
		
		if(r == N-1 && c == M-1) {
			return 1;
		}
		
		dp[r][c] = 0;
		
		for(int i=0;i<4;i++) {
			int nextR = r + dir[i][0];
			int nextC = c + dir[i][1];
			
			if(isIn(nextR,nextC) && arr[r][c] > arr[nextR][nextC]) {
				
				// 처음 방문하는 곳이라면
				if(dp[nextR][nextC] == -1)
					dp[r][c] += find(nextR,nextC);
				// 방문했던 곳이라면 
				else if(dp[nextR][nextC] >= 1)
					dp[r][c] += dp[nextR][nextC];
				
			}			
		}
		
		return dp[r][c];
	}
	
	private static boolean isIn(int r, int c) {
		return r<N && r>=0 && c<M && c >=0;
	}
}
