package week10.day0916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_17472 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M;
	static int[][] map;
	static int[] repres;
	static List<Point> list = new ArrayList<>();
	static int DDANG;
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
	static PriorityQueue<Edge> pq;
	static int totalCost;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		DDANG=2;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 1) {
					dfs(i, j);
					DDANG++;//맨처음이 2로 될 거고 다음 지역은 3
					//원래 1이었던 값에서 그냥 구분자로(2부터 시작하면 왔던 곳을 구분할 수 있다)
				}
			}
		}//노드의 위치로
//		for(int[] arr:map) {
//			System.out.println(Arrays.toString(arr));
//		}
		pq = new PriorityQueue<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]>1) {
					makeEdgeList(i,j);
				}
			}
		}
		kruskal();
		System.out.println(totalCost);
	}
	
	private static void makeEdgeList(int i, int j) {
		int baseIdx = map[i][j];
		for(int d=0; d<4; d++) {
			for(int l=1; ;l++) {
				//언제까지인지 모르겠지만 계속 가보는 거
				int nr = i+deltas[d][0]*l;
				int nc = j+deltas[d][1]*l;
				if(isIn(nr,nc)) {
					if(map[nr][nc]==0) {
						//바다면 계속
						continue;
					}else if(map[nr][nc] ==baseIdx) {
						//우리땅이면
						break;
					}else {
						//남의 땅이면 거리를 보고 가중치를 넣는다.
						if(l>2) {
							pq.add(new Edge(baseIdx, map[nr][nc], l-1));
						}
						break;
					}
				}else {
					break;
				}
			}
		}
	}

	private static void dfs(int r, int c) {
		map[r][c] = DDANG;
		for(int d=0; d<4; d++) {
			int nr = r + deltas[d][0];
			int nc = c + deltas[d][1];
			
			if(isIn(nr,nc) && map[nr][nc]==1) {
				dfs(nr,nc);
			}
			
		}
		
	}
	static void kruskal() {
		make();
		while(!pq.isEmpty()) {
			Edge head = pq.poll();
			union(head.nodeA, head.nodeB, head.cost);
		}
		int repre = find(2);//시작 노드
		for(int i=3; i<repres.length; i++) {
			if(repre != find(repres[i])) {
				totalCost = -1;
				break;
			}
		}
	}
	private static void make() {
		repres = new int[DDANG];
		for(int i=2; i<repres.length; i++) {
			repres[i]=i;
		}
	}
	private static int find(int a) {
		if(repres[a]==a) {
			return a;
		}else {
			return repres[a] = find(repres[a]);
		}
	}
	private static void union(int a, int b, int cost) {
		a = find(a);
		b = find(b);
		if(a==b) {
			return;
		}
		repres[a] = b;
		totalCost += cost;
	}
	private static boolean isIn(int nr, int nc) {
		return 0<=nr && nr<N && 0<=nc && nc<M;
	}

	static class Point{
		int r,c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
	static class Edge implements Comparable<Edge> {
		int nodeA, nodeB, cost;

		public Edge(int nodeA, int nodeB, int cost) {
			super();
			this.nodeA = nodeA;
			this.nodeB = nodeB;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
//			return this.weight-o.weight;//간선의 부호가 모두 같을 떄 사용 하고
			return Integer.compare(this.cost, o.cost);// 다를 수 있을 때 사용
		}

		@Override
		public String toString() {
			return "Edge [nodeA=" + nodeA + ", nodeB=" + nodeB + ", cost=" + cost + "]";
		}
		
		
		
	}
}
