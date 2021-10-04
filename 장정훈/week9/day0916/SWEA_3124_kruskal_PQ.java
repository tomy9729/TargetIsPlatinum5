package week10.day0916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_3124_kruskal_PQ {

	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int V, E;
	static Edge[] edgeList;
	static int[] repres; // 부모원소를 관리
	static PriorityQueue<Edge> pq;
	static long totalCost;
	static int edgeCnt;//V-1까지
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
//		int TC = Integer.parseInt(br.readLine());
//		for (int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
//			edgeList = new Edge[E];
			pq = new PriorityQueue<>();
			totalCost = 0;
			edgeCnt = 0;
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
//				edgeList[i] = new Edge(start - 1, end - 1, weight);
				pq.offer(new Edge(start, end, weight));
			}
			make();
			while(!pq.isEmpty()) {
				Edge head = pq.poll();
				union(head.nodeA, head.nodeB, head.cost);
				if(edgeCnt == V-1) {
					break;
				}
			}
//			sb.append("#" + t + " " + totalCost+"\n");
//		}
		System.out.println(totalCost);
	}

	//각각의 원소를 개별 집단으로 구성해준다.
	private static void make() {
		repres = new int[V+1];
		// 모든 원소를 자신을 대표자로 만듦
		for (int i = 1; i <repres.length; i++) {
			repres[i] = i;
		}
	}

	//집합의 대표자를 조회한다. 이때 path compression
	private static int find(int a) {
		// a가 속한 집합의 대표자 찾기
		if (a == repres[a])
			return a;

		return repres[a] = find(repres[a]);// 자신이 속한 집합의 대표자를 자신의 부모로 : path compression
	}

	//조직의 두목만 나와서 확인한다.
	private static void union(int a, int b,int cost) {
		// 두 원소를 하나의 집합으로 합치기(대표자를 이용해서 합침);
		int aRoot = find(a);//a의 두목을 데리고 옴
		int bRoot = find(b);//b의 두목을 데리고 옴
		if (aRoot == bRoot)
			return;// 이미 같은 집합으로 합치지 않음.
		else {
			repres[bRoot] = aRoot;
			//정점이 새롭게 연결되면 간선이 생기면서 비용이 발생.
			totalCost+=cost;
			edgeCnt++;
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
