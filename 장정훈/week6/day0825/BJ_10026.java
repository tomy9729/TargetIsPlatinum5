package week7.day0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10026 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static char[][] map1;
	static char[][] map2;
	static boolean[][] visited1;
	static boolean[][] visited2;
	static int N;
	static int[] dA = { -1, 1, 0, 0 };
	static int[] dB = { 0, 0, -1, 1 };

	static int aPart;
	static int bPart;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		map1 = new char[N][N];
		map2 = new char[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map1[i][j] = str.charAt(j);
				if (map1[i][j] == 'G') {
					map2[i][j] = 'R';// 적록색약일 떄 바로 빨간색으로 넣어주기
				} else {
					map2[i][j] = str.charAt(j);
				}
			}
		}
		visited1 = new boolean[N][N];
		visited2 = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited1[i][j]) {
					aPart++;
					dfs(i, j, map1, visited1, map1[i][j]);
				}
				if (!visited2[i][j]) {
					bPart++;
					dfs(i, j, map2, visited2, map2[i][j]);
				}
			}
		}

		System.out.println(aPart + " " + bPart);
	}

	private static void dfs(int i, int j, char[][] map, boolean[][] visited, char color) {

		visited[i][j] = true;

		for (int d = 0; d < 4; d++) {
			int ni = i + dA[d];
			int nj = j + dB[d];
			if (isIn(ni, nj) && !visited[ni][nj] && map[ni][nj] == color) {
				dfs(ni, nj, map, visited, color);
			}
		}

	}

	private static boolean isIn(int ni, int nj) {
		return 0 <= ni && ni < N && 0 <= nj && nj < N;
	}

}
