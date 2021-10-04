package week9.day0909;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_17829 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] map;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int answer = parse(N,0,0);
		System.out.println(answer);
	}

	private static int parse(int n,int r, int c) {
		if(n==2) {
			int[] ary = new int[4];
			ary[0] = map[r][c];
			ary[1] = map[r][c+1];
			ary[2] = map[r+1][c];
			ary[3] = map[r+1][c+1];
			Arrays.sort(ary);
			return ary[2];
		}
		int[] arr = new int[4];
		arr[0] = parse(n/2, r, c);
		arr[1] = parse(n/2, r, c+n/2);
		arr[2] = parse(n/2, r+n/2, c);
		arr[3] = parse(n/2, r+n/2, c+n/2);
		Arrays.sort(arr);
		return arr[2];
	}

}
