package week15.day1019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class day1019 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M;
	static int[][] map;
	static int[][] cur;
	static int[][] deltas = {{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
	static Queue<int[]> Q;
	static int Max;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cur = new int[N][M];
		Q = new LinkedList<>();
		Max = 0;
		for(int i=0; i<N; i++) {
			Arrays.fill(cur[i], Integer.MAX_VALUE);
		}
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					Q.offer(new int[] {i,j});
					cur[i][j] = 0;
				}
			}
		}
		
		bfs();
		
		System.out.println(Max);
	}

	private static void bfs() {
		
		while(!Q.isEmpty()) {
			int[] arr = Q.poll();
			
			for(int d=0; d<8; d++) {
				int nr = arr[0] + deltas[d][0];
				int nc = arr[1] + deltas[d][1];
				
				if(isIn(nr,nc) && cur[nr][nc] > cur[arr[0]][arr[1]]+1 ) {
					cur[nr][nc] = cur[arr[0]][arr[1]]+1;
					Max = Math.max(Max, cur[nr][nc]);
					Q.offer(new int[] {nr,nc});
				}
			}
			
			
		}
		
	}

	private static boolean isIn(int nr, int nc) {
		return 0<=nr && nr<N && 0<=nc && nc<M;
	}
}
