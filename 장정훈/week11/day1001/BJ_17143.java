package week12.day1001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17143 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int R, C, M;
	static shark[][] map;
	static Queue<shark> Q;
	static int[][] deltas = {{},{-1,0},{1,0},{0,1},{0,-1}};
	static PriorityQueue<shark> PQ;
	//d가 1인 경우는 위, 2인 경우는 아래, 3인 경우는 오른쪽, 4인 경우는 왼쪽을 의미한다.
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new shark[R+1][C+1];
		Q = new LinkedList<>();
		PQ = new PriorityQueue<>();
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int speed = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			map[r][c] = new shark(r, c, speed, d, size);
		}
		int result = 0;

		
		for(int j=1; j<=C; j++) {
			//j가 증가하는 게 1번
			result += hunt(j);
			//상어 잡는 게 2번.
			move();
		}
		
		System.out.println(result);
		
	}
	
	private static void move() {
		shark[][] copyMap = new shark[R+1][C+1];
		for(int r=1; r<=R; r++) {
			for(int c=1; c<=C; c++) {
				shark s = map[r][c];
				if(s !=null) {
					map[r][c] = null;
					s.move();
					shark pre = copyMap[s.r][s.c];
					if(pre==null) {
						copyMap[s.r][s.c] = s;
					}else if(pre.size < s.size) {
						copyMap[s.r][s.c] = s;
					}
				}
			}
		}
		map = copyMap;
		
	}

	private static boolean isIn(int nr, int nc) {
		return 1<=nr && nr<=R && 1<=nc && nc<=C;
	}
	
	private static int hunt(int j) {
		int result = 0;
		for(int i=1; i<=R; i++) {
			if(map[i][j] != null) {
				result = map[i][j].size;
				map[i][j] = null;
				break;
			}
		}
		return result;
	}

	static class shark implements Comparable<shark>{
		
		int r,c;
		int speed;
		int d;
		int size;
		
		int delta;//1 or -1로
		boolean isHor;//상하인지, 좌우인지
		
		public shark(int r, int c, int speed, int d, int size) {
			super();
			this.r = r;
			this.c = c;
			this.speed = speed;
			this.d = d;
			this.size = size;
			
			this.isHor = this.d>2;//좌우일때 true 상하일 때 좌우
			
			
			this.delta=(d==1 || d==4)? -1 : 1; // 상 혹은 좌 일때
			
			if(this.isHor) {
				this.speed = this.speed% ((C-1)*2);
			}else {
				this.speed = this.speed% ((R-1)*2);
				
			}
			
		}
		
		
		public void move() {
			if(isHor) {
				for(int i=0; i<speed; i++) {
					c+= delta;
					if(c==0) {
						c=2;
						delta*= -1;
					}else if(c==C+1) {
						c = C-1;
						delta *= -1;
					}
				}
			}else {
				for(int i=0; i<speed; i++) {
					r+= delta;
					if(r==0) {
						r=2;
						delta *= -1;
					}else if(r==C+1) {
						r = R-1;
						delta *= -1;
					}
				}
			}
		}
		

		@Override
		public String toString() {
			return "shark [r=" + r + ", c=" + c + ", speed=" + speed + ", d=" + d + ", size=" + size + "]";
		}


		@Override
		public int compareTo(shark o) {
			if(this.r == o.r && this.c == o.c) {
				return Integer.compare(this.size, o.size)*-1;
			}
			return Integer.compare(this.speed, o.speed);
			
		}
		
		
		
	}
}
