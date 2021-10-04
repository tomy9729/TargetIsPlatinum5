package week7.day0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_1753_review3 {//PriorityQueue 사용
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int V, E;
	static int Start;
//	static int[][] graph;
	static LinkNode[] graph;
	static PriorityQueue<LinkNode> PQ = new PriorityQueue<>();
	
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
		//pq에 가장 작은 점 넣어주기.
		PQ.offer(new LinkNode(Start,0));//출발점과 출발점의 비용 0
		while(!PQ.isEmpty()) {
			LinkNode minDistNode = PQ.poll();
			//뺀 노드가 방문했던 지점인지 확인.
			if(visited[minDistNode.no]) {
				continue;
			}
			// 방문 처리
			visited[minDistNode.no] = true;
			
			//방문 가능한 지점들 가보기
			LinkNode next = graph[minDistNode.no];
			while(next != null) {
				if(!visited[next.no] && dist[next.no] > dist[minDistNode.no] + next.weight) {
					dist[next.no] = dist[minDistNode.no] + next.weight;
					PQ.offer(new LinkNode(next.no, dist[next.no]));
				}
				next = next.pre;
			}
			
		}
		
		for(int i=1; i<=V; i++) {
			sb.append(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]).append("\n");
		}
		System.out.println(sb);
	}

	static class LinkNode implements Comparable<LinkNode>{//정점의 정보를 저장할 클래스
		//누적값을 가지고 비교
		int no;//갈 곳
		int weight;//가중치
		int totalCost;//각 정점에 도달하는 비용
		LinkNode pre;
		public LinkNode(int no, int weight, LinkNode pre) {//그래프를 만들기 위한 생성자
			super();
			this.no = no;
			this.weight = weight;
			this.pre = pre;
		}
		
		public LinkNode(int no, int totalCost) {// PQ를 사용하기 위한 생성자
			super();
			this.no = no;
			this.totalCost = totalCost;
		}

		@Override
		public String toString() {
			return "LinkNode [no=" + no + ", weight=" + weight + ", pre=" + pre + "]";
		}
		@Override
		public int compareTo(LinkNode o) {
			return Integer.compare(this.totalCost, o.totalCost);
		}
		
		
		
	}
	
}
