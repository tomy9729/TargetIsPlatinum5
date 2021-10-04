package week12.day0930;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1953 {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M,R,C,L;
	static int[][] map;
	static boolean[][] visited;
	static Queue<Point> Q;
	static List<Point> list;
	static int[][][] deltas = {
			{},
			{{-1,0},{1,0},{0,-1},{0,1}},
			{{-1,0},{1,0}},
			{{0,-1},{0,1}},
			{{-1,0},{0,1}},
			{{1,0},{0,1}},
			{{1,0},{0,-1}},
			{{-1,0},{0,-1}}
	};
	static int[][][] check = {
			{},
			{{1,2,5,6},{1,2,4,7},{1,3,4,5},{1,3,6,7}},//상하좌우일 때 갈 수 있는 곳
			{{1,2,5,6},{1,2,4,7}},//상,하로 갈 수 있는 곳
			{{1,3,4,5},{1,3,6,7}},//좌,우로 갈 수 있는 곳
			{{1,2,5,6},{1,3,6,7}},//상,우로 갈 수 있는 곳
			{{1,2,4,7},{1,3,6,7}},//하,우로 갈 수 있는 곳
			{{1,2,4,7},{1,3,4,5}},//하,좌로 갈 수 있는 곳
			{{1,2,5,6},{1,3,4,5}}//상,좌로 갈 수 있는 곳
	};
	
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input_SWEA1953.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int result=0;
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new boolean[N][M];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0; j<M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			bfs();
			
		
			
			sb.append("#"+t+" "+list.size()+"\n");
		}
		System.out.println(sb);
	}
	
	private static void bfs() {
		Q = new LinkedList<>();
		list = new ArrayList<>();
		
		visited[R][C] = true;
		Q.offer(new Point(R, C, 1,map[R][C]));
		
		while(!Q.isEmpty()) {
			Point now = Q.poll();
			if(now.time <=L) {
				list.add(now);
			}else {
				break;//큰 게 나오는 순간 볼 필요 없음
			}
			
			for(int d=0; d<deltas[now.type].length; d++) {
				int nr = now.r + deltas[now.type][d][0];
				int nc = now.c + deltas[now.type][d][1];
				if(isIn(nr,nc)&&!visited[nr][nc] && map[nr][nc] !=0) {
					boolean flag = false;
					int next = map[nr][nc];
					for(int c=0; c<check[now.type][d].length; c++) {
						if(next==check[now.type][d][c]) {
							flag = true;
							break;
						}
					}
					if(flag) {
						visited[nr][nc] = true;
						Q.offer(new Point(nr, nc, now.time+1, map[nr][nc]));
					}
				}
				
			}
		}
		
	}

	private static boolean isIn(int nr, int nc) {
		return 0<=nr && nr < N && 0<=nc && nc<M;
	}

	static class Point{
		int r,c;
		int time;
		int type;
		public Point(int r, int c, int time, int type) {
			super();
			this.r = r;
			this.c = c;
			this.time = time;
			this.type = type;
		}
	
		
		
		
	}
}
