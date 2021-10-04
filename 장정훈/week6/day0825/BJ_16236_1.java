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

public class BJ_16236_1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[][] map;
	static boolean[][] boolMap;
	static int babyShark;
	static int I, J;
	static int[] dA = { -1, 0, 0, 1 };
	static int[] dB = { 0, -1, 1, 0 };
	static int time;
	static boolean nyam;
	static List<Fish> ocean;

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
					I = i;
					J = j;
				} // 상어 위치 저장.
				else if (0 < map[i][j] && map[i][j] <= 6) {
					ocean.add(new Fish(i, j, map[i][j]));
					cnt++;
					flag = true;
				}
			}
		}
		if (flag) {
			if (cnt == 1) {
				Fish f = ocean.get(0);
				f.len(I, J);
				int len = f.l;
				if (f.size >= map[I][J]) {
					System.out.println(0);
				} else {
					System.out.println(len);
				}
			} else {

				find();
				System.out.println(time);
			}
		} else {
			System.out.println(0);
		}
	}

	private static void find() {
		boolean flag = true;
		int eat = 0;
		time = 1;
		while (flag) {
//			for (int i = 0; i < ocean.size(); i++) {
//				ocean.get(i).len(I, J);
//			}
//			Collections.sort(ocean);
//
//			for (int i = 0; i < ocean.size(); i++) {
//				Fish fish = ocean.get(i);
//				if (fish.size < babyShark) {
			nyam = false;
			System.out.println(time);

			int kill = move(I, J, 0);// 먹을 수 있었는지 없는지 확인.
			if (nyam) {// 냠냠 -> I,J가 최신화 되어서 돌아올 것
				eat++;
				time += kill;
				if (eat == babyShark) {
					eat = 0;
					babyShark++;// 잘 먹어서 부풀어 오른 아기 상어
				}
				flag = true;
//						ocean.remove(i);
			} else {
				System.out.println("In");
				flag = false;// 먹을 수는 있는데 거기까지 못 가는 물고기였을 때. -> I,J가 그대로
			}
//				} else {
//					flag = false;
//					continue;
//				}
//			}
//
		}

	}

	private static int move(int i, int j, int cnt) {
		boolean[][] visited = new boolean[N][N];
		int kill =0;
		Queue<int[]> Q = new LinkedList<int[]>();
		for (int d = 0; d < 4; d++) {
			int ni = i + dA[d];
			int nj = j + dB[d];
			if (isIn(ni, nj) && !visited[ni][nj] && map[ni][nj] <= babyShark) {
				visited[ni][nj] = true;
				if (map[ni][nj] != 0 && map[ni][nj] < babyShark) {
					nyam = true;
					map[I][J]=0;
					I = ni;
					J = nj;
					map[I][J] = 9;
					return 1;
				}
				Q.add(new int[] { ni, nj, cnt+1 });
			}
		}
		while (!Q.isEmpty()) {
			int[] arr = Q.poll();
			
			for (int d = 0; d < 4; d++) {
				
				int ni = arr[0] + dA[d];
				int nj = arr[1] + dB[d];
				if (isIn(ni, nj) && !visited[ni][nj] && map[ni][nj] <= babyShark) {
					visited[ni][nj] = true;
					if (map[ni][nj] != 0 && map[ni][nj] < babyShark) {
						nyam = true;
						map[I][J]=0;
						I = ni;
						J = nj;
						map[I][J] = 9;
						return arr[2]+1;
					}
					Q.add(new int[] { ni, nj, d ,arr[2]+1});
				}
			}
			
		}
		System.out.println("Out");
		
		return kill;
	}

	private static boolean isIn(int ni, int nj) {
		return 0 <= ni && ni < N && 0 <= nj && nj < N;
	}

	static class Fish implements Comparable<Fish> {
		int r, c;
		int l;// 상어랑 거리
		int size;

		public Fish(int r, int c, int size) {
			super();
			this.r = r;
			this.c = c;
			this.size = size;
		}

		public void len(int i, int j) {
			this.l = Math.abs(i - r) + Math.abs(j - c);
		}

		@Override
		public int compareTo(Fish o) {
			if (this.l != o.l) {
				return Integer.compare(this.l, o.l);
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
