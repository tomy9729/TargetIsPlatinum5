package week13.day1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5656 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, W, H;
//	static int[][] map;
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int min;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			int result = 0;
			min = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			int[][] map = new int[H][W];
			for (int h = 0; h < H; h++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int w = 0; w < W; w++) {
					map[h][w] = Integer.parseInt(st.nextToken());
				}
			}
			
			permutation(0, map);

			sb.append("#" + t + " " + min + "\n");
		}
		System.out.println(sb);
	}

	private static void permutation(int cnt, int[][] map) {
		if (cnt == N) {
			min = Math.min(min, count(map));
			return;
		}

		int[][] copy = new int[H][W];
		for (int c = 0; c < W; c++) {
			int r = 0;
			while (r < H && map[r][c] == 0)
				r++;
			if (r == H) {
				permutation(cnt + 1, map);
			} else {
				copy(map, copy);
				bfs(r, c, copy);
				down(copy);
				permutation(cnt+1,copy);
			}

		}

	}

	private static void copy(int[][] map, int[][] copy) {
		for(int r=0; r<H; r++) {
			for(int c=0; c<W; c++) {
				copy[r][c] = map[r][c];
			}
		}
		
	}

	private static int count(int[][] map) {
		int sum =0;
		for(int r=0; r<H; r++) {
			for(int c=0; c<W; c++) {
				if(map[r][c] !=0) {
					sum++;
				}
			}
		}
		return sum;
	}

	private static void down(int[][] map) {
		for(int c=0; c<W; c++) {
			Queue<Integer> Q = new LinkedList<>();
			for(int r=H-1; r>=0; r--) {
				if(map[r][c] != 0) {
					Q.add(map[r][c]);
				}
			}
			for(int r=H-1; r>=0; r--) {
				if(Q.isEmpty()) {
					map[r][c] = 0;
				}
				else {
					map[r][c] = Q.poll();
				}
			}
		}
		
	}
	

	private static void bfs(int r, int c, int[][] map) {

		Queue<Point> Q = new LinkedList<>();
		if(map[r][c] > 1) {
			Q.offer(new Point(r, c, map[r][c]));
		}
		map[r][c] = 0;
		while (!Q.isEmpty()) {
			Point now = Q.poll();
			for (int dist = 1; dist < now.Num; dist++) {
				for (int d = 0; d < 4; d++) {
					int nr = now.r + deltas[d][0]*dist;
					int nc = now.c + deltas[d][1]*dist;
					if (isIn(nr, nc) && map[nr][nc] != 0) {
						if(map[nr][nc] >1) {
							Q.offer(new Point(nr, nc, map[nr][nc]));
						}
						map[nr][nc] = 0;
					}
				}
			}
		}

	}

	private static boolean isIn(int nr, int nc) {
		return 0 <= nr && nr < H && 0 <= nc && nc < W;
	}

	static class Point {
		int r, c;
		int Num;

		public Point(int r, int c, int num) {
			super();
			this.r = r;
			this.c = c;
			Num = num;
		}

	}
}
