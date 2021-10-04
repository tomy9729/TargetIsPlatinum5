package week6.day0819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_3109 {

	static BufferedReader br;
	static StringTokenizer st;
	static char[][] map;
	static int R,C;
	static int Max;
	static int[][] deltas = {{-1,1},{0,1},{1,1}};//오른쪽 대각 위, 앞, 오른쪽 대각 밑
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for(int r=0; r<R; r++) {
			String str = br.readLine();
			map[r] = str.toCharArray();
		}
		
		play(0);
		
		System.out.println(Max);
	}

	private static void play(int cnt) {
		if(cnt==R) {
			return;
		}
		move(cnt,0,0);
		play(cnt+1);
	}

	private static void move(int i, int j,int cnt) {
		if(j==C-1) {
			Max++;
		}
		
		map[i][j]='x';
		int m = Max;
		for(int d=0; d<3; d++) {
			int ni = i + deltas[d][0];
			int nj = j + deltas[d][1];
			if(isIn(ni,nj)&&map[ni][nj]=='.') {
				
				move(ni,nj,cnt+1);
				if(m!=Max) {
					break;
				}
			}
		}
		
	}

	private static boolean isIn(int ei, int ej) {
		return ((ei>=0&&ei<R)&&(ej>=0&&ej<C));
	}

}
