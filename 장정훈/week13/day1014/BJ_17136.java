package week14.day1014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_17136 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] map;
	static int[] paper;
	static int result;
	
	public static void main(String[] args) throws IOException {
		map = new int[10][10];
		result = Integer.MAX_VALUE;
		paper = new int[5];
		Arrays.fill(paper, 5);
		for(int i=0; i<10; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0,0);
		
		if(result == Integer.MAX_VALUE) {
			result = -1;
		}
		System.out.println(result);
	}

	private static void dfs(int r, int c, int cnt) {
		if(r==10) {
			result = Math.min(result, cnt);
			return;
		}
		if(c>9) {
			dfs(r+1,0,cnt);
			return;
		}
		if(cnt>result) {
			return;
		}
		if(map[r][c]==1) {
			for(int p=0; p<5; p++) {
				boolean flag = true;
				out : for(int i=r; i<=r+p; i++) {
					for(int j=c; j<=c+p; j++) {
						if(!isIn(i,j) || map[i][j] ==0) {
							flag = false;
							break out;
						}
					}
				}
				if(paper[p] >0 && flag) {
					
					for(int i=r; i<=r+p; i++) {
						for(int j=c; j<=c+p; j++) {
							map[i][j] = 0;
						}
					}
					paper[p]--;
					
					dfs(r,c+1,cnt+1);
					
					for(int i=r; i<=r+p; i++) {
						for(int j=c; j<=c+p; j++) {
							map[i][j] = 1;
						}
					}
					paper[p]++;
					
				}
				
			}
		}else {
			//1이 아닐 때는 덮을 필요 없음
			dfs(r,c+1,cnt);
		}
		
	}

	private static boolean isIn(int nr, int nc) {
		return 0<=nr && nr<10 && 0<=nc && nc<10;
	}
	
	
	
}
