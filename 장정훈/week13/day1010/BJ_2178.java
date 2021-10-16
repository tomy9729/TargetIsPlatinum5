package week14.day1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2178 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M;
	static int[][] map;
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+1][M+1];
		visited = new boolean[N+1][M+1];
		for(int i=1; i<N+1; i++) {
			char[] arr = br.readLine().toCharArray();
			for(int j=1; j<M+1; j++) {
				map[i][j] = arr[j-1]-'0';
			}
		}
		
		bfs();
		System.out.println(map[N][M]);
		
	}

	private static void bfs() {
		Queue<int[]> Q = new LinkedList<>();
		Q.add(new int[] {1,1});
		visited[1][1] = true;
		
		while(!Q.isEmpty()) {
			int[] arr = Q.poll();
			for(int d=0; d<4; d++) {
				int nr = arr[0] + deltas[d][0];
				int nc = arr[1] + deltas[d][1];
				
				if(isIn(nr,nc) && !visited[nr][nc] && map[nr][nc]!=0) {
					Q.add(new int[] {nr,nc});
					map[nr][nc] = map[arr[0]][arr[1]]+1;
					visited[nr][nc] = true;
				}
				
			}
		}
		
	}
	
	private static boolean isIn(int nr, int nc) {
		return 1<=nr && nr<N+1 && 1<=nc && nc <M+1;
	}
}
