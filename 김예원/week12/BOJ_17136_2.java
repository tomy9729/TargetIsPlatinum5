package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17136_2 {
	static int N = 10, ans = Integer.MAX_VALUE;
	static int[] size = {0, 5, 5, 5, 5, 5};
	static int[][] paper = new int[N][N];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			for(int j = 0; j < N; j++)
				paper[i][j] = Integer.parseInt(st.nextToken());
		}
		
		
		dfs(0, 0, 0);
		
		if(ans == Integer.MAX_VALUE)
			ans = -1;
		
		System.out.println(ans);
		
	}
	
	private static void dfs(int r, int c, int cnt) {
		if(cnt >= ans)
			return;
		
		if(r == N) {
			ans = cnt;
			return;
		}
		
		if(c >= N) {
			dfs(r + 1, 0, cnt);
			return;
		}
		
		if(paper[r][c] == 1) {
			int max = 1;
			
			here: for(int n = 1; n < 5; n++) {
				if(c + n >= N || r + n >= N || paper[r + n][c + n] == 0)
					break here;
				
				for(int nr = r; nr < r + n; nr++)
					if(paper[nr][c + n] == 0)
						break here;
				
				for(int nc = c; nc < c + n; nc++)
					if(paper[r + n][nc] == 0)
						break here;
				
				max++;
			}
			
			for(int n = max; n > 0; n--) {
				if(size[n] > 0) {
					putPaper(r, c, n, 0);
					dfs(r, c + n, cnt + 1);
					putPaper(r, c, n, 1);
				}
			}
		}
		else
			dfs(r, c + 1, cnt);
			
	}
	
	private static void putPaper(int r, int c, int n, int val) {
		for(int i = r; i < r + n; i++)
			for(int j = c; j < c + n; j++)
				paper[i][j] = val;
		
		if(val == 0)
			size[n]--;
		else
			size[n]++;
	}
	
}
