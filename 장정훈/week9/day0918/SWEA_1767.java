package week10.day0918;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1767 {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[][] map;
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
	static List<Point> list;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input_SWEA1767.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int t=1; t<=TC; t++) {
			int result=0;
			N = Integer.parseInt(br.readLine());
			map = new int[N+2][N+2];
			list = new ArrayList<>();
			for(int i=1; i<N+1; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=1; j<N+1; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
//					if(i==1 || i==N || j==1 || j==N) {
//						continue;
//					}
					if(map[i][j]==1) {
						list.add(new Point(i,j));
					}
				}
			}
			//~
			for(int i=0; i<N+2; i++) {
				map[0][i] = -1;
			}
			
			for(int i=0; i<N+2; i++) {
				map[N+1][i] = -1;
			}
			for(int i=1; i<N+2; i++) {
				map[i][0]= -1;
				map[i][N+1] = -1;
			}
			//여기까지 테두리에 -1 넣기.
			for(int[] arr:map) {
				System.out.println(Arrays.toString(arr));
			}
			dfs(0);
			for(int i=0; i<list.size(); i++) {
				result += list.get(i).len;
			}
			sb.append("#"+t+" "+result+"\n");
			for(int[] arr:map) {
				System.out.println(Arrays.toString(arr));
			}
		}
		System.out.println(sb.toString());
	}
	
	private static void dfs(int idx) {
		//일직선 dfs 1인 구역으로부터 -1(테두리)까지.
		if(idx==list.size()) {
			return;
		}
		int r = list.get(idx).r;
		int c = list.get(idx).c;
		int way = 0;
		for(int d=0; d<4; d++) {
			int nr=r;
			int nc=c;
			int len =0;
			while(true) {
				nr += deltas[d][0];
				nc += deltas[d][1];
				if(isIn(nr, nc) && map[nr][nc]==0) {
					len++;
				}else if(map[nr][nc]==-1) {
					int a = list.get(idx).len;
					int b = len;
					list.get(idx).len = Math.min(len, list.get(idx).len);
//					if(list.get(idx).len ==len) {
//						way = d;
//					}
					
					break;
				}else {
					break;
				}
			}
			
		}
//		int nr = r+deltas[way][0];
//		int nc = c+deltas[way][1];
//		while(map[nr][nc] ==0) {
//			map[nr][nc] = 1;
//			if(map[nr][nc]==-1) {
//				break;
//			}
//			nr += deltas[way][0];
//			nc += deltas[way][1];
//			
//		}
		dfs(idx+1);
		
	}
	
	
	
	private static boolean isIn(int nr, int nc) {
		return 1<=nr && nr<N+1 && 1<=nc && nc<N+1;
	}
	
	static class Point{
		int r,c;
		int len = Integer.MAX_VALUE;
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
}
