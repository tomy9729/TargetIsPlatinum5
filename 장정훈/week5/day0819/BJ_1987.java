package week6.day0819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1987 {

	static BufferedReader br;
	static StringTokenizer st;
	static char[][] map;
	static int R, C;
	static int Max;
	static int semi;
	static boolean[] check;
	static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };// 상하좌우
	List<Al> lsit = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		check = new boolean[26];// 대문자 알파벳 26개
		Max = Integer.MIN_VALUE;
		semi = 0;
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();

		}
		play(0, 0, 1);
		System.out.println(Max);
	}

	private static void play(int i, int j, int cnt) {

		check[map[i][j] - 'A'] = true;

//		boolean flag = false;
		for (int d = 0; d < 4; d++) {
			int ni = i + deltas[d][0];
			int nj = j + deltas[d][1];
			if (isIn(ni, nj) && !(check[map[ni][nj] - 'A'])) {

				play(ni, nj, cnt + 1);

			}
		}
		check[map[i][j]-'A'] = false;
		Max = Math.max(Max, cnt);

	}

	private static boolean isIn(int ni, int nj) {
		return ((ni >= 0 && ni < R) && (nj >= 0 && nj < C));
	}

	static class Al {// 대충 알파벳 클래스

		char alphabet;
		int cnt;
		int checkCnt;

		public Al(char alphabet, int cnt, int checkCnt) {
			super();
			this.alphabet = alphabet;
			this.cnt = cnt;
			this.checkCnt = checkCnt;
		}

	}

}
