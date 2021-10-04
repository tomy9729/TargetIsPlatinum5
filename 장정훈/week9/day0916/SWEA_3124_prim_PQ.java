package week10.day0916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_3124_prim_PQ {

	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int V, E;
	static LinkNode[] graph;
	static long totalCost;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken())+1;
			E = Integer.parseInt(st.nextToken())+1;
			graph = new LinkNode[V];
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				graph[start] = new LinkNode(end, weight, graph[start]);
				graph[end] = new LinkNode(start, weight, graph[end]);
				
			}
			totalCost = prim();
			
			
			sb.append("#" + t + " " + totalCost+"\n");
		}
		System.out.println(sb.toString());
	}
	static long prim() {
		PriorityQueue<LinkNode> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[V];
		//임의의 한 점에서 출발한다.
		pq.offer(new LinkNode(1, 0));
		//방문체크는 원래 BFS였으면 여기서
//		visited[1] = true; 이렇게 했을텐데 우리는 빼면서 할 거다.
		int visitCnt = 1;//방문한 녀석들의 횟수를 관리한다.
		long sum =0 ;
		while(!pq.isEmpty()) {
			//1. 맨 앞에 가져오기
			LinkNode head = pq.poll();
			//뺐을 때 방문 여부에 대한 처리를 한다.
			//2.방문 여부에 대한 처리 및 사용
			if(visited[head.i]) {
				continue;
			}//방문했으면 넘김.
			visited[head.i] = true;
			sum+=head.cost;
			//모든 정점에 대한 연결이 끝났다면, PQ에 남아있는 값들은 볼 필요가 없다.
			if(++visitCnt == V) {
				return sum;
			}
			//3.가능한 자식 탐색
			LinkNode pre = graph[head.i];
			while (pre!=null) {
				if(!visited[pre.i]) {
					pq.offer(new LinkNode(pre.i, pre.cost));
					//여기서 담았지만, 방문처리는 하지 않는다. -- 방문처리를 하는 건 뽑아서 사용할 때
					//쓸모 없는 애들도 들어갈 수 있다.
				}
				pre = pre.pre;
			}
		}
		
		
		return -1;//그냥 리턴값이 필요해서 넣음
	}

	static class LinkNode implements Comparable<LinkNode>{
		int i;
		int cost;
		LinkNode pre;//그래프 구성을 위해서 필요한 녀석 -> PQ를 쓰면 필요가 없어진다.
		public LinkNode(int i, int cost, LinkNode pre) {
			super();
			this.i = i;
			this.cost = cost;
			this.pre = pre;
		}
		
		public LinkNode(int i, int cost) {
			super();
			this.i = i;
			this.cost = cost;
		}

		@Override
		public int compareTo(LinkNode o) {
			return Integer.compare(this.cost, o.cost);
		}
		
		
	}
}
