package week15.day1019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_18428 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static char[][] map;
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
	static boolean status;
	static List<int[]> list;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		list = new ArrayList<>();
		int c=0;
		for(int i=0; i<N; i++) {
			char[] arr = br.readLine().toCharArray();
			for(int j=0; j<N; j++) {
				map[i][j] = arr[j];
				if(map[i][j] == 'T') {
					list.add(new int[] {i,j});
				}
			}
		}
		dfs(0,0,0);
		if(status) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}
	private static void dfs(int r,int c, int cnt) {
		if(status) {
			return;
		}
		if(c==N) {
			c=0;
			r++;
		}
		if(r==N) {
			return;
		}
		if(cnt==3) {
			status = find()? true : false;
		}
		if(map[r][c]=='X') {
			map[r][c] ='O';
			dfs(r,c+1, cnt+1);
			map[r][c] = 'X';
		}
		dfs(r,c+1,cnt);
		
	}
	private static boolean find() {
		
		for(int l=0; l<list.size(); l++) {
			int[] arr = list.get(l);
			for(int d=0; d<4; d++) {
				int nr = arr[0]; 
				int nc = arr[1];
				while(true) {
					nr += deltas[d][0];
					nc += deltas[d][1];
					if(!isIn(nr,nc)|| map[nr][nc]=='O') {
						break;
					}
					if(map[nr][nc] == 'S') {
						return false;
					}
					
				}
			}
		}
		return true;
	}
	private static boolean isIn(int nr, int nc) {
		return 0<=nr && nr < N && 0<= nc && nc<N;
	}
}
