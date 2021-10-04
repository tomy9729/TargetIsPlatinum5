package week7.day0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1260 {

	static int N,V;
	static boolean[][] adjMatrix;//인접행렬//무향그래프 
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		adjMatrix = new boolean[N+1][N+1];
		int C = Integer.parseInt(st.nextToken());//간선개수
		V = Integer.parseInt(st.nextToken());
		for(int i=0; i<C; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjMatrix[to][from] = true;
			adjMatrix[from][to] = true;
		}
		/*
		boolean[] visited = new boolean[N];
		visited[0] = true;
		dfs(0,visited);//방법1
		*/
		dfs(V,new boolean[N+1]);//방법2
		System.out.println();
		bfs();
		
	}
	private static void dfs(int current, boolean[] visited) {
		visited[current] = true;//방법2.
		System.out.print(current+" ");
		for(int i=0; i<visited.length; i++) {
			if(!visited[i] && adjMatrix[current][i]) {
//				visited[i] = true;//방법1
				dfs(i,visited);
			}
		}
		
	}
	private static void bfs() {
		
		Queue<Integer> Q = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		Q.offer(V);
		visited[V] = true;
		while(!Q.isEmpty()) {
			int current = Q.poll();
			System.out.print(current+" ");
			
			
			for(int i=0; i<visited.length; i++) {
				if(!visited[i] && adjMatrix[current][i]) {//방문하지 않았을 때와 인접 정점인지 확인
					Q.offer(i);
					visited[i] = true;
				}
			}
			
		}
		
	}

}
