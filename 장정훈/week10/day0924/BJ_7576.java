package week11.day0924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7576 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M;
	static int[][] map;
	static Queue<Point> q;
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
	static int result;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		q = new LinkedList<>();
		result=0;
		boolean flag = true;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==0) {
					flag = false;
				}else if(map[i][j]==1) {
					q.offer(new Point(i, j));
				}
			}
		}
		if(flag) {
			//0이 없으면 자라날 게 없음.
			System.out.println(0);
		}else {
			bfs();
			if(check()) {
				System.out.println(result);
			}else {
				System.out.println(-1);
			}
		}
	}

	private static boolean check() {
		boolean flag = true;
		out: for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] ==0) {
					flag = false;
					break out;
				}
			}
		}
		
		return flag;
	}

	private static void bfs() {
		
		while(!q.isEmpty()) {
			Point arr = q.poll();
			for(int d=0; d<4; d++) {
				int nr = arr.r + deltas[d][0];
				int nc = arr.c + deltas[d][1];
				
				if(isIn(nr,nc) && map[nr][nc] == 0) {
					map[nr][nc] = 1;
					q.offer(new Point(nr, nc, arr.Cnt+1));
				}
				
			}
			result = Math.max(result, arr.Cnt);
		}
		
	}

	private static boolean isIn(int nr, int nc) {
		return 0<=nr && nr <N && 0<=nc && nc<M;
	}
	
	static class Point{
		int r,c;
		int Cnt;
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			Cnt = cnt;
		}
		
	}
}
