package week10.day0916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_9205_review {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T,N;
	static Point[] points;
	static int[][] graph;
	static String answer;
	public static void main(String[] args) throws IOException {
		T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine());
			points = new Point[N+2];
			for(int i=0; i<points.length; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				points[i] = new Point(x,y);
			}
			
			graph = new int[N+2][N+2];
			for(int r=0; r<N+2; r++) {
				for(int c=0; c<N+2; c++) {
					int dist = points[r].calDist(points[c]);
					if(dist <= 1000) {
						graph[r][c] = 1;
					}
				}
			}//그래프 완성.
			
			answer = "sad";
//			dfs(0, new boolean[N+2]);
			bfs();
//			System.out.println(answer);
			sb.append(answer+"\n");
		}
		System.out.println(sb.toString());
	}
	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N+2];
		q.offer(0);
		visited[0] = true;
		while(!q.isEmpty()) {
			Integer head = q.poll();
			
			if(head==N+1) {
				answer="happy";
				return;
			}
			for(int c=0; c<N+2; c++) {
				if(!visited[c] && graph[head][c] ==1) {
					visited[c] = true;
					q.offer(c);
				}
			}
			
		}
	}
	static void dfs(int start, boolean[] visited) {
		visited[start] = true;
		
		if(start == N+1) {
			answer = "happy";
		}
		
		for(int c=0; c<N+2; c++) {
			if(!visited[c] && graph[start][c] ==1) {
				dfs(c,visited);
			}
		}
	}
	
	
	static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		public int calDist(Point other) {
			return Math.abs(this.x-other.x) + Math.abs(this.y-other.y);
		}
		
	}
	
}
