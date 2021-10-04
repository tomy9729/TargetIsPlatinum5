package week12.day0930;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1249 {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,min;
	static int[][] map;
	static boolean[][] visited;
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input_SWEA1249.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				char[] extra = br.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = extra[j] - '0';
				}
			}
			min = Integer.MAX_VALUE;

//			for (int[] arr : map) {
//				System.out.println(Arrays.toString(arr));
//			}
			bfs();

//			System.out.println(map[N - 1][N - 1]);
			sb.append("#"+t+" "+min+"\n");
		}
		System.out.println(sb);

	}

	private static void bfs() {
		int[][] subMap = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(subMap[i], Integer.MAX_VALUE);
		}
		subMap[0][0] = 0;
		Queue<Point> Q = new LinkedList<>();
		Q.offer(new Point(0, 0));
		visited[0][0] = true;
		while (!Q.isEmpty()) {
			Point now = Q.poll();

			if(now.r == N-1 && now.c == N-1) {
				min = Math.min(min, subMap[N-1][N-1]);
			}
			
			if(min <= subMap[now.r][now.c]) {
				continue;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = now.r + deltas[d][0];
				int nc = now.c + deltas[d][1];
				if (isIn(nr, nc)) {
					if (!visited[nr][nc] || subMap[nr][nc] > subMap[now.r][now.c] + map[nr][nc]) {
						subMap[nr][nc] = subMap[now.r][now.c] + map[nr][nc];
						Q.offer(new Point(nr, nc));
						visited[nr][nc] = true;
					}
				}
			}

		}
		map = subMap;

	}

	private static boolean isIn(int nr, int nc) {
		return 0 <= nr && nr < N && 0 <= nc && nc < N;
	}

	static class Point {
		int r, c;
		
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
			
		}

	}
}
