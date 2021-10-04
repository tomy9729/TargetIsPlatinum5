package week11.day0924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class JO_1681_fail {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] map;
	static int[] parents;
	static int totalCost,edgeCnt;
	static int N;
	static PriorityQueue<Edge> pq;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		pq = new PriorityQueue<>();
		totalCost = 0;
		edgeCnt = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==0) {
					continue;
				}
				if(j==0) {
					pq.offer(new Edge(i+1, N+1, map[i][j]));//돌아가는 길(n->1)을 구하기 위해 1로 가는 길을 N번 노드로 지정해준다.
				}else {
					pq.offer(new Edge(i+1, j+1, map[i][j]));
				}
			}
		}
		make();
		while(!pq.isEmpty()) {
			Edge head = pq.poll();
			union(head.nodeA, head.nodeB, head.cost);
			
		}
		System.out.println(totalCost);
		
	}
	
	private static void make() {
		parents = new int[N+2];//마지막에 출발지점으로 돌아오는 걸 N으로 넣었기 때문에.
		for (int i = 1; i < parents.length; i++) {
			parents[i] = i;
		}
		
	}
	
	private static int find(int n) {
		
		if(n == parents[n]) {
			//부모가 자기 자신.
			return n;
		}
		return parents[n] = find(parents[n]);
	
	}
	
	private static void union(int nodeA, int nodeB, int cost) {
		
		int rootA = find(nodeA);
		int rootB = find(nodeB);
		if(rootA == rootB) {
			return;
		}
		parents[rootB] = rootA;
		totalCost += cost;
		edgeCnt++;
	}
	
	
	

	static class Edge implements Comparable<Edge>{
		int nodeA;
		int nodeB;
		int cost;
		public Edge(int nodeA, int nodeB, int cost) {
			super();
			this.nodeA = nodeA;
			this.nodeB = nodeB;
			this.cost = cost;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
		
		
		
	}
	
}
