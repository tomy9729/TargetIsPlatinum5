package week7.day0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14696 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] A;
	static int[] B;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {

			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			A = new int[5];
			B = new int[5];
			for (int i = 0; i < a; i++) {
				A[Integer.parseInt(st.nextToken())]++;
			}
			st = new StringTokenizer(br.readLine(), " ");
			int b = Integer.parseInt(st.nextToken());
			for (int i = 0; i < b; i++) {
				B[Integer.parseInt(st.nextToken())]++;
			}
			if (A[4] > B[4]) {
				sb.append("A\n");
			} else if (A[4] < B[4]) {
				sb.append("B\n");
			} else {
				if (A[3] > B[3]) {
					sb.append("A\n");
				} else if (A[3] < B[3]) {
					sb.append("B\n");
				} else {
					if (A[2] > B[2]) {
						sb.append("A\n");
					} else if (A[2] < B[2]) {
						sb.append("B\n");
					} else {
						if (A[1] > B[1]) {
							sb.append("A\n");
						} else if (A[1] < B[1]) {
							sb.append("B\n");
						} else {
							sb.append("D\n");
						}
					}
				}
			}

		}
		System.out.println(sb.toString());
	}

}
