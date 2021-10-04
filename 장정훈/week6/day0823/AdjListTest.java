package week7.day0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AdjListTest {
	//인접 행렬
	static int N;
	static boolean[][] adjMatrix;//인접행렬//무향그래프 
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		adjMatrix = new boolean[N][N];
		int C = Integer.parseInt(br.readLine());//간선개수
		for(int i=0; i<C; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjMatrix[to][from] = true;
			adjMatrix[from][to] = true;
		}
		bfs();
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
		/*
		boolean[] visited = new boolean[N];
		visited[0] = true;
		dfs(0,visited);//방법1
		*/
		dfs(0,new boolean[N]);//방법2
	}
	private static void dfs(int current, boolean[] visited) {
		visited[current] = true;//방법2.
		System.out.println((char)(current+65));
		for(int i=0; i<visited.length; i++) {
			if(!visited[i] && adjMatrix[current][i]) {
//				visited[i] = true;//방법1
				dfs(i,visited);
			}
		}
		
	}
	private static void bfs() {
		
		Queue<Integer> Q = new LinkedList<>();
		boolean[] visited = new boolean[N];
		Q.offer(0);
		visited[0] = true;
		while(!Q.isEmpty()) {
			int current = Q.poll();
			System.out.println((char)(current+65));
			
			
			for(int i=0; i<visited.length; i++) {
				if(!visited[i] && adjMatrix[current][i]) {//방문하지 않았을 때와 인접 정점인지 확인
					Q.offer(i);
					visited[i] = true;
				}
			}
			
		}
		
	}

}
