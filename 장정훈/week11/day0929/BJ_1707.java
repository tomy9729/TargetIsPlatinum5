package week12.day0929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1707 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,V,E;
	static LinkNode[] graph;
	//방문처리 미방문 0 1그룹 2그룹
	static int[] visited;
	static String answer;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {			
			st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			graph = new LinkNode[V+1];
			
			for(int e=0; e<E; e++) {
				st= new StringTokenizer(br.readLine()," ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[a] = new LinkNode(b, graph[a]);
				graph[b] = new LinkNode(a, graph[b]);
				
			}
			visited = new int[V+1];
			answer = "YES";
			for(int i=1; i<graph.length; i++) {
				if(visited[i] == 0 && answer.equals("YES")) {
					//방문하지 않았고 현재 답이 YES인 상태면 계속 확인.
					dfs(i,1);
				}
			}
			sb.append(answer+"\n");
		}
		System.out.println(sb.toString());
	}
	private static void dfs(int nodeNum, int groupNum) {
		//방문처리
		visited[nodeNum] = groupNum;
		
		LinkNode child = graph[nodeNum];
		while(child != null) {
			if(visited[child.n]==0) {
				//미방문이면 dfs
				dfs(child.n,groupNum*-1);
			}else {
				//방문 했던 거면 자기 자신의 그룹넘버랑 비교
				if(visited[nodeNum] == visited[child.n]) {
					//같으면 이분그래프 아님
					answer = "NO";
					return;
				}
			}
			
			child = child.pre;
			
		}
	}
	static class LinkNode{
		int n;
		LinkNode pre;
		public LinkNode(int n, LinkNode pre) {
			super();
			this.n = n;
			this.pre = pre;
		}
		
	}
}
