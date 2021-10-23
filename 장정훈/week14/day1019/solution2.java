package week15.day1019;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class solution2 {
	
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int map[][];
	static boolean mapCheck[][];
	static boolean go[][];
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("test1.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			go = new boolean[N][N];
			mapCheck = new boolean[N][N];
			int sr = 0 , sc = 0;//start R C
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 2) {
						sr = i;
						sc = j;
					}
				}
			}
			
			bfs(sr,sc);
			for(boolean[] arr : go) {
				for(int i=0; i<arr.length; i++) {
					System.out.print(arr[i]+"\t");
				}
				System.out.println();
			}
			sb.append("#"+t+" "+check()+"\n");
		}
		System.out.println(sb.toString());
		
	}


	private static void bfs(int sr,int sc) {
		Queue<Point> Q = new LinkedList<>();
		Q.offer(new Point(sr, sc, 0));
		
		while(!Q.isEmpty()) {
			Point now = Q.poll();
			if(now.cnt>=3) {
				
				break;
			}
			for(int d=0; d<4; d++) {
				int nr = now.r;
				int nc = now.c;
				int cnt = 0;
				in: while(true) {
					nr += deltas[d][0];
					nc += deltas[d][1];
					if(!isIn(nr, nc)) {
						break;
					}
					
					if(cnt==1) {
						Q.offer(new Point(nr, nc, now.cnt+1));
						go[nr][nc] = true;
//						break in;
					}
					if(map[nr][nc] == 1) {
						cnt++;
					}
					
				}
			}
		}
	}


	private static boolean isIn(int nr, int nc) {
		return 0<=nr && nr < N && 0<=nc && nc<N;
	}


	private static int check() {
		int result = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]==1 && go[i][j]) {
					result++;
				}
			}
		}
		
		return result;
	}
	
	static class Point{
		int r,c;
		int cnt;
		
		public Point() {
			
		}

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
		
	}
}
