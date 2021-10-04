package week10.day0915;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1600 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int K;
	static int W,H;
	static int[][] MAP;
	static int[][] horseVer = {{-1,-2},{-2,-1},{-2,1},{-1,2},
								{1,2},{2,1},{2,-1},{1,-2}};
	static int[][] monkeyVer = {{-1,0},{1,0},{0,-1},{0,1}};
	static int cnt = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		MAP = new int[H][W];
		for(int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<W; j++) {
				MAP[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		play();
		System.out.println(cnt);
	}
	private static void play() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {0,0,0,K});
		boolean[][] check = new boolean[H][W];
		check[0][0] = true;
		while(!q.isEmpty()) {
			int[] rc = q.poll();
			int r=rc[0];
			int c=rc[1];
			int ct=rc[2];
			int cur = rc[3];
			if(r==H-1&&r==W-1) {
				cnt = ct;
				return;
			}
			for(int i=0; i<4; i++) {
				int nr = r+monkeyVer[i][0];
				int nc = c+monkeyVer[i][1];
				if(isIn(nr,nc)&&!check[nr][nc]&&MAP[nr][nc]!=1) {
					 check[nr][nc] = true;
					 q.add(new int[] {nr, nc,ct+1,cur});
					 
				}
			}
			if(cur<=0) {
				continue;
			}
			for(int i=0; i<8; i++) {
				int nr = r+horseVer[i][0];
				int nc = c+horseVer[i][1];
				if(isIn(nr,nc)&&!check[nr][nc]&&MAP[nr][nc]!=1) {
					 check[nr][nc] = true;
					 q.add(new int[] {nr, nc,ct+1,cur-1});
					 
				}
			}
			
	
			
			
		}
		
	}
	private static boolean isIn(int nr, int nc) {
		return 0<= nr && nr<H && 0<=nc && nc <W;
	}

}
