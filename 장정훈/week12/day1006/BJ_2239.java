package week13.day1006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2239 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] map;
	static boolean[][] blockCheck;
	static boolean[][] verticalCheck;
	static boolean[][] horizontalCheck;

	public static void main(String[] args) throws IOException {
		map = new int[9][9];
		blockCheck = new boolean[9][10];
		verticalCheck = new boolean[9][10];
		horizontalCheck = new boolean[9][10];
		for (int r = 0; r < 9; r++) {
			char[] extra = br.readLine().toCharArray();
			for (int c = 0; c < 9; c++) {
				map[r][c] = extra[c] - '0';
				if (map[r][c] != 0) {
					verticalCheck[c][map[r][c]] = true;// 왼쪽에서 i번째 열에 있는 숫자 체크
					horizontalCheck[r][map[r][c]] = true;// 위에서 i번째 행에 있는 숫자 체크
					blockCheck[c / 3 + 3 * (r / 3)][map[r][c]] = true;// 0 1 2
																// 3 4 5
																// 6 7 8 블록에 있는 숫자 체크
				}
			}
		}

//		play();
		play(0, 0);
		for (int[] arr : map) {
			for (int a : arr) {
				sb.append(a);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());

	}

//	private static void play() {
//		for (int i = 0; i < 9; i++) {
//			for (int j = 0; j < 9; j++) {
//				if (map[i][j] == 0) {
//					find : for (int f = 1; f <= 9; f++) {
//						if (!verticalCheck[j][f] && !horizontalCheck[i][f] && !blockCheck[whereIn(i, j)][f]) {
//							map[i][j] = f;
//							verticalCheck[j][f] = true;
//							horizontalCheck[i][f] = true;
//							blockCheck[whereIn(i, j)][f] = true;
//							break find;
//						}
//					}
//				}
//			}
//		}
//	}

	private static boolean play(int r, int c) {
		int nr = r;
		int nc = c + 1;
		if (c == 8) {
			nr++;
			nc = 0;
		}
		if (r == 9) {

			return true;
		}

		if (map[r][c] != 0) {
			return play(nr, nc);

		} else {
			for (int f = 1; f <= 9; f++) {
				if (!verticalCheck[c][f] && !horizontalCheck[r][f] && !blockCheck[c / 3 + 3 * (r / 3)][f]) {
					map[r][c] = f;
					verticalCheck[c][f] = true;
					horizontalCheck[r][f] = true;
					blockCheck[c / 3 + 3 * (r / 3)][f] = true;
					if (play(nr, nc)) {
						return true;
					}
					map[r][c] = 0;
					verticalCheck[c][f] = false;
					horizontalCheck[r][f] = false;
					blockCheck[c / 3 + 3 * (r / 3)][f] = false;
				}
			}

		}
		return false;
	}

	private static int whereIn(int r, int c) {
		if (0 <= r && r < 3 && 0 <= c && c < 3) {
			return 0;
		} else if (0 <= r && r < 3 && 3 <= c && c < 6) {
			return 1;
		} else if (0 <= r && r < 3 && 6 <= c && c < 9) {
			return 2;
		} else if (3 <= r && r < 6 && 0 <= c && c < 3) {
			return 3;
		} else if (3 <= r && r < 6 && 3 <= c && c < 6) {
			return 4;
		} else if (3 <= r && r < 6 && 6 <= c && c < 9) {
			return 5;
		} else if (6 <= r && r < 9 && 0 <= c && c < 3) {
			return 6;
		} else if (6 <= r && r < 9 && 3 <= c && c < 6) {
			return 7;
		} else if (6 <= r && r < 9 && 6 <= c && c < 9) {
			return 8;
		}
		return -1;
	}
}
