package week7.day0826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_3190 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, K, L;
	static int[][] map;
	static Deque<Info> info;
	static Deque<Snake> snake;
	
	static int sWay;
	static int[][] deltas = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };// 상 우 하 좌 오른쪽 90도일 때는 증가 왼쪽 90도일 때는 감소
	static int T;

	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		
		sWay = 1; // 오른쪽으로 시작.
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 1;
		}
		
		L = Integer.parseInt(br.readLine());
		info = new ArrayDeque<>();
		snake = new ArrayDeque<>();
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			info.add(new Info(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0)));
		}
		snake.add(new Snake(1, 1));
		play(1,1,1);
		System.out.println(T);
	}

	private static void play(int i,int j,int cnt) {
		
		Info s = info.peekFirst();
		Snake sn = snake.peekLast();
		
		map[sn.r][sn.c] = 5;
		
		if (s != null && s.time == cnt) {
			info.pollFirst();
			
			if (s.way == 'D') {
				sWay++;
				if (sWay == 4) {
					sWay = 0;
				}
			} else if (s.way == 'L') {
				sWay--;
				if (sWay == -1) {
					sWay = 3;
				}
			}
			
		}
			
		int	ni = sn.r + deltas[sWay][0];
		int	nj = sn.c + deltas[sWay][1];
		
		
		
		if (isIn(ni, nj) && map[ni][nj] != 5) {
			snake.add(new Snake(ni, nj));
			if (map[ni][nj] != 1) {
				snake.pollFirst();
			}
			
			play(ni,nj,cnt+1);
		} else if(!isIn(ni,nj) || map[ni][nj] == 5){
			T = cnt+1;
			return;
		}

	}

	private static boolean isIn(int ni, int nj) {
		return 0 < ni && ni <= N  && 0 < nj && nj <= N;
	}
	
	static class Snake{
		int r,c;

		public Snake(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}

	static class Info {

		int time;
		char way;

		public Info(int time, char way) {
			super();
			this.time = time;
			this.way = way;
		}
	}

}
