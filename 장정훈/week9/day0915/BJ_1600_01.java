package week10.day0915;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1600_01 {
	//3차원 배열로 푸는 문제. 이거보다 더 복잡해지면 비트마스킹을 활용
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
		
		System.out.println(bfs());
	}
	private static int bfs() {
		//방문여부를 체크하는데 이때 말모드였을 때 원숭이 모드였을 때를 나누기 위해서 3차원 배열로 한다.
		boolean [][][] visited = new boolean[H][W][K+1];
		Queue<monkey> q = new LinkedList<>();
		q.add(new monkey(0, 0, 0));//(0,0)에서 0번 움직임.
		visited[0][0][0] = true;
		//현재 큐가 가지고 있는 사이즈 만큼 돌려야 한다.
		int depth = 0;
		while(!q.isEmpty()) {
			int size = q.size();
			//현재 큐가 가지고 있는 것만 가지고 돈다.
			while(size-- >0){
				//1. 맨 처음 녀석을 가지고 온다..
				monkey head = q.poll();
				
				//2. 사용한다 - 정답이니?(목적지:맨 오른쪽 아래인지 확인)
				if(head.r==H-1 && head.c== W-1) {
					return depth;
				}
				//3. 자식 탐색
				//사방탐색한다.+추가로 말모드로 이동할 수 있는 횟수가 남아있으면 말모드탐색
				
				moveLike(monkeyVer, head, true, visited, q);
				
				if(head.k<K) {
					moveLike(horseVer, head, false, visited, q);					
					
				}
			}
			depth++;
		}
		
		return -1;//목적지에 도달 못 하면 여기로 올 것이다.
	}
	static void moveLike(int[][] delats, monkey head, boolean isMonkey,boolean[][][] visited,Queue<monkey> q) {
		for(int d=0; d<delats.length; d++) {
			int nr = head.r+delats[d][0];
			int nc = head.c+delats[d][1];
			if(isIn(nr,nc) && MAP[nr][nc]==0) {
				int horseMove = isMonkey ? head.k : head.k+1;
				if(!visited[nr][nc][horseMove]) {
					monkey newMonkey = new monkey(nr, nc, horseMove);
					visited[nr][nc][horseMove] = true;
					q.offer(newMonkey);
				}
			}
		}
	}
	private static boolean isIn(int nr, int nc) {
		return 0<= nr && nr<H && 0<=nc && nc <W;
	}
	static class monkey{
		int r,c,k;//좌표, 말로 이동할 수 있는 횟수

		public monkey(int r, int c, int k) {
			super();
			this.r = r;
			this.c = c;
			this.k = k;
		}
		
	}
	
}
