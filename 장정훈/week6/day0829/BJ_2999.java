package week7.day0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2999 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static char[][] strMap;

	public static void main(String[] args) throws IOException {
		String str = br.readLine();
		int N = str.length();
		int i = 0, j = 0;
		int e = (int) Math.sqrt(N);

		for (int n = 1; n <= e; n++) {
			if (N % n == 0) {
				i = n;
				j = N / n;
			}
		}
		
		strMap = new char[i][j];
		int st = 0;
		for(int c=0; c<j; c++) {
			for(int r=0; r<i; r++) {
				strMap[r][c] = str.charAt(st++);
			}
		}
		for(int r=0; r<i; r++) {
			for(int c=0; c<j; c++) {
				sb.append(strMap[r][c]);
			}
		}
		System.out.println(sb.toString());
	}

}
