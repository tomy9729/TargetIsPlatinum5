package week7.day0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1753_review2 {//인접 리스트 방식
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int V, E;
	static int Start;
//	static int[][] graph;
	static LinkNode[] graph;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		Start = Integer.parseInt(br.readLine());
//		graph = new int[V+1][V+1];
		graph = new LinkNode[V+1];
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
//			graph.get(from).add(new int[] {to,weight});
//			graph[from][to] = weight;
			graph[from] = new LinkNode(to, weight, graph[from]);
		}
		dijkstra();
	}

	private static void dijkstra() {
		// 필요한 요소 준비하기
		int[] dist = new int[V+1];
		boolean[] visited = new boolean[V+1];
		
		//초기화
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[Start] = 0;
		for(int v=1; v<=V; v++) {
			// 미방문인 지점 중 최소 비용인 곳
			int minV = 0;
			int minCost = Integer.MAX_VALUE;
			for(int i=1; i<=V; i++) {
				if(!visited[i] && dist[i]<minCost) {
					minV = i;
					minCost = dist[i];
				}
			}
			visited[minV] = true;
			
//			for(int c=1; c<=V; c++) {
//				if(!visited[c] && graph[minV][c] > 0 && dist[c] > dist[minV] + graph[minV][c] ) {
//					dist[c] = dist[minV] + graph[minV][c];
//				}
//			}
			LinkNode next = graph[minV];
			while(next != null) {
				if(!visited[next.no] && dist[next.no]  >dist[minV] + next.weight) {
					dist[next.no] = dist[minV] + next.weight;
				}
				next = next.pre;
			}
			
			
		}
		
		for(int i=1; i<=V; i++) {
			sb.append(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]).append("\n");
		}
		System.out.println(sb);
	}

	static class LinkNode{//정점의 정보를 저장할 클래스
		int no;//갈 곳
		int weight;//가중치
		LinkNode pre;
		public LinkNode(int no, int weight, LinkNode pre) {
			super();
			this.no = no;
			this.weight = weight;
			this.pre = pre;
		}
		@Override
		public String toString() {
			return "LinkNode [no=" + no + ", weight=" + weight + ", pre=" + pre + "]";
		}
		
		
		
	}
	
}
