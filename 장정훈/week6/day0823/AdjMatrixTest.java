package week7.day0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class AdjMatrixTest {
	// 인접 행렬
	static int N;
	static Node[] adjList;// 인접행렬//무향그래프
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		adjList = new Node[N];
		int C = Integer.parseInt(br.readLine());// 간선개수
		for (int i = 0; i < C; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, adjList[from]);
			adjList[to] = new Node(from, adjList[to]);
		}
		bfs();
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
		/*
		 * boolean[] visited = new boolean[N]; visited[0] = true; dfs(0,visited);//방법1
		 */
		dfs(0, new boolean[N]);// 방법2
	}

	private static void dfs(int current, boolean[] visited) {
		visited[current] = true;// 방법2.
		System.out.println((char) (current + 65));
		for (Node temp = adjList[current]; temp != null; temp = temp.link) {
			if (!visited[temp.vertex]) {
				dfs(temp.vertex,visited);
			}
		}

	}

	private static void bfs() {

		Queue<Integer> Q = new LinkedList<>();
		boolean[] visited = new boolean[N];
		Q.offer(0);
		visited[0] = true;
		while (!Q.isEmpty()) {
			int current = Q.poll();
			System.out.println((char) (current + 65));

			for (Node temp = adjList[current]; temp != null; temp = temp.link) {
				if (!visited[temp.vertex]) {
					Q.add(temp.vertex);
					visited[temp.vertex] = true;
				}
			}

		}

	}

	static class Node {

		int vertex;// 인접정적 인덱스
		Node link;

		public Node(int vertex, Node link) {
			super();
			this.vertex = vertex;
			this.link = link;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", link=" + link + "]";
		}

	}
}
