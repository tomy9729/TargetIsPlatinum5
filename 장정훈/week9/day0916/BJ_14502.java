package week10.day0916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_14502 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int R,C;
	static int[][] map;
	static int[] choice;
	static int[] number;
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};//상하좌우
	static int maxCnt;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		number = new int[R*C];
		choice = new int[3];
		maxCnt = 0;
		int c=0;
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==0) {
					number[c] = c;
				}else {
					number[c] = -1;
				}
				c++;
			}
		}
		//조합으로 
		combi(0,0);
		System.out.println(maxCnt);
	}
	private static void combi(int cnt, int idx) {
		if(cnt == 3) {
			bfs();
			return;
		}
		for(int i=idx; i<R*C; i++) {
			if(number[i]==-1) {
				continue;
			}
			choice[cnt] = number[i];
			combi(cnt+1,i+1);
		}
		
	}
	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		int[][] copyMap = new int[R][C];
		int c=0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(choice[0]==c||choice[1]==c||choice[2]==c) {
					copyMap[i][j] = 1;
				}else {
					copyMap[i][j] = map[i][j];
				}
				if(copyMap[i][j]==2) {
					q.add(new int[] {i,j});
				}
				c++;
			}
		}
		while(!q.isEmpty()) {
			int[] virus = q.poll();
			
			for(int d=0; d<4; d++) {
				int nr = virus[0] + deltas[d][0];
				int nc = virus[1] + deltas[d][1];
				if(isIn(nr,nc)&&copyMap[nr][nc]==0) {
					copyMap[nr][nc] = 2;
					q.add(new int[] {nr,nc});
				}
			}
			
		}
		check(copyMap);
	}
	private static void check(int[][] copyMap) {
		int sum =0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(copyMap[i][j]==0) {
					sum++;
				}
			}
		}

		maxCnt = Math.max(maxCnt, sum);
		
	}
	private static boolean isIn(int nr, int nc) {
		
		return 0<=nr && nr<R && 0<= nc && nc<C;
	}
}
