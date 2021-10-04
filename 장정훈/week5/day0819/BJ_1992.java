package week6.day0819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1992 {

	static BufferedReader br;
	static StringBuilder sb = new StringBuilder();
	static char[][] map;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			map[i] = str.toCharArray();
		}

		find(0, 0, N);

		System.out.println(sb.toString());
	}

	private static void find(int i, int j, int cnt) {//원래 있던 코드는 문제를 잘못 파악해서 모두 1이면 (1 1 1 1)이어야 되는 줄 알았음.
		if(pressure(i, j, cnt)) {
			sb.append(map[i][j]);
		}else {
			int half = cnt / 2;
			sb.append("(");
			find(i,j,half);
			find(i,j+half,half);
			find(i+half,j,half);
			find(i+half,j+half,half);
			sb.append(")");
		}
	}

	private static boolean pressure(int i, int j, int cnt) {
		boolean flag = true;
		
		out: for(int x=i; x<i+cnt; x++) {
			for(int y=j; y<j+cnt; y++) {
				if(map[i][j]!=map[x][y]) {
					flag = false;
					break out;
				}
			}
		}
		
		return flag;
	}

}
