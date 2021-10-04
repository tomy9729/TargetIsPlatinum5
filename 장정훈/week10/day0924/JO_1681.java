package week11.day0924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class JO_1681 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] map;
	static boolean[] visited;
	static int totalCost;
	static int N;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new boolean[N];
		totalCost = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
			}
		}
		visited[0] = true;
		dfs(1,0,0);
		
		
		System.out.println(totalCost);
		
	}

	private static void dfs(int cnt, int cur, int sum) {
		if(sum>totalCost) {
			return;
		}
		if(cnt==N) {
			if(map[cur][0]!=0 && totalCost>sum+map[cur][0]) {
				totalCost = sum+map[cur][0];
			}
		}
		for(int i=1; i<N; i++) {
			if(map[cur][i] !=0 && !visited[i]) {
				visited[i] = true;
				dfs(cnt+1, i, sum+map[cur][i]);
				visited[i] = false;
			}
		}
	}
	
	
	
}
