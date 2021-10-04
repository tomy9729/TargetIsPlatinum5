package week7.day0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_10157 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] Map;
	static int N, M;
	static int R, C;
	static int find;
	static int cnt;
	static int[][] deltas = {{-1,0},{0,1},{1,0},{0,-1}};
	
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		Map = new int[N + 1][M + 1];
		find = Integer.parseInt(br.readLine());
		cnt =1;
		if (find > N * M) {
			System.out.println("0");
		} else {
			for (int i = 0; i < N + 1; i++) {
				Map[i][0] = -1;
			}
			for (int j = 0; j < M + 1; j++) {
				Map[0][j] = -1;
			}
			int r = N;
			int c = 1;
			Map[r][c] = cnt;
			play(r,c,0);//r,c부터 시작해서 find가 나올 때까지. 상 우 하 좌 방향으로 돌 예정.
			System.out.println(C+" "+R);
		}
//		for (int[] a : Map) {
//			System.out.println(Arrays.toString(a));
//		}
	}


	private static void play(int r, int c, int way) {
		if(cnt == find) {
			R = N-r+1;
			C = c;
			return;
		}
		Map[r][c] = cnt;
		int nr = r + deltas[way][0];
		int nc = c + deltas[way][1];
		if(isIn(nr,nc)&&Map[nr][nc]==0) {
			cnt++;
			play(nr,nc,way);
		}else {
			way++;
			if(way == 4) {
				way = 0;
			}
			
			play(r,c,way);
		}
	}


	private static boolean isIn(int nr, int nc) {
		return 0<nr&& nr<=N && 0<nc && nc<=M;
	}

}
