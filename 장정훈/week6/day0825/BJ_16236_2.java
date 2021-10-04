package week7.day0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16236_2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[][] map;
	static boolean[][] boolMap;
	static int babyShark;
	static int I, J;
	static int[] dA = { -1, 1, 0, 0 };
	static int[] dB = { 0, 0, -1, 1 };
	static int time;
	static boolean nyam;
	static List<Fish> ocean;
	static Shark shark;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// BFS 문제...?
		N = Integer.parseInt(br.readLine());
		boolean flag = false;
		int cnt = 0;
		ocean = new ArrayList<>();
		babyShark = 2;
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					shark = new Shark(i, j, 2, 0);
					map[i][j] = 0;
				} // 상어 위치 저장.
				else if (0 < map[i][j] && map[i][j] <= 6) {
					cnt++;
					flag = true;
				}
			}
		}
		if (flag) {
			bfs(shark);
			System.out.println(time);
		}else {
			System.out.println(0);
		}
	}

	private static void bfs(Shark shark) {

		// BFS의 필수 Q
		Queue<Shark> que = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		Fish target = null;
		que.offer(shark);
		visited[shark.row][shark.col] = true;
		int dep = 0;// 물고기를 먹으러 이동한 거리.
		while (!que.isEmpty()) {
			int size = que.size();
			while (size-- > 0) {
				Shark extra = que.poll();

				for (int d = 0; d < 4; d++) {
					int ni = extra.row + dA[d];
					int nj = extra.col + dB[d];
					if (isIn(ni, nj) && !visited[ni][nj]) {
						visited[ni][nj] = true;
						// 물고기와의 크기를 바탕으로 실제 이동 가능한지 확인.
						if (map[ni][nj] == 0 || map[ni][nj] == extra.size) {
							que.offer(new Shark(ni, nj, extra.size, extra.eatCnt));
						} else if (map[ni][nj] < extra.size) {
							// 먹을 수 있다는 것을 표시 해둬야 한다.
							Fish fish = new Fish(ni, nj, map[ni][nj], dep + 1);
							if (target == null) {
								target = fish;
							} else {// 비교
									// 우선 순위를 고려하여 target변경
								target = target.compareTo(fish) < 0 ? target : fish;
							}
						}
					}
				}
			} // size만큼 -- 즉, 현재의 depth 처리 완료.
				// 먹을 게 발견됐다면? 냠
			if (target != null) {
				break;
			}
			dep++;
		} // que가 완전히 빈 상태 또는 break;

		// 먹을 게 있어서 끝났는지 없어서 끝났는지 확인.
		if (target == null) {
			return;
		} else {
			shark.eat();
			map[target.r][target.c] = 0;
			time += target.dist;
			// 다른 물고기 먹으로 또 감.
			bfs(new Shark(target.r, target.c, shark.size, shark.eatCnt));
		}

	}

	private static boolean isIn(int ni, int nj) {
		return 0 <= ni && ni < N && 0 <= nj && nj < N;
	}

	static class Shark {
		int row, col, size, eatCnt;

		public Shark(int row, int col, int size, int eatCnt) {
			super();
			this.row = row;
			this.col = col;
			this.size = size;
			this.eatCnt = eatCnt;
		}

		public void eat() {
			eatCnt++;
			if (eatCnt == this.size) {
				this.size++;
				eatCnt = 0;
			}
		}

	}

	static class Fish implements Comparable<Fish> {
		int r, c;
		int dist;// 상어랑 거리
		int size;

		public Fish(int r, int c, int size, int dist) {
			super();
			this.r = r;
			this.c = c;
			this.dist = dist;
			this.size = size;
		}

		@Override
		public int compareTo(Fish o) {
			if (this.dist != o.dist) {
				return Integer.compare(this.dist, o.dist);
			} else {
				if (this.r != o.r) {
					return Integer.compare(this.r, o.r);
				} else {
					return Integer.compare(this.c, o.c);
				}
			}
		}

	}

}
