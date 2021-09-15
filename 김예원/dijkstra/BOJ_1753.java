package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1753 {

	static int V, E, K;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//정점의 개수 V
		V = Integer.parseInt(st.nextToken());
		//간선의 개수 E
		E = Integer.parseInt(st.nextToken());

		// 시작 정점
		K = Integer.parseInt(br.readLine());
		final int INFINITY = Integer.MAX_VALUE;
		
		int[][] matrix = new int[V+1][V+1];
		boolean[] visited = new boolean[V+1];
		int[] distance = new int[V+1]; 
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			// 방향이 있다!
			// 유향 그래프
			matrix[u][v] = w;
		}
		
		// 각 정점마다 실행
		for(int index=1;index<=V;index++) {
			int start = K; int end =index;
			visited = new boolean[V+1];
			Arrays.fill(distance, INFINITY);
			distance[start] = 0;
			
			
			int min=0, current=0;
			for(int i=1; i<=V; ++i){
				//a단계 : 방문하지 않은 정점들 중 최소가중치의 정점 선택
				min = INFINITY;
				for(int j=1; j<=V; ++j){
					if(!visited[j] && distance[j] < min){
						min = distance[j];
						current = j;
					}
				}
				visited[current] = true; // 선택 정점 방문 처리
				if(current == end){ // 선택 정점이 도착정점이면 탈출.
					break;
				}
				
				//b단계: current정점을 경유지로 하여 갈수 있는 다른 방문하지 않은 정점들에 대한 처리
				for(int c=1; c<=V; ++c){
					if(!visited[c] && matrix[current][c] != 0
							&&  distance[c] > min+matrix[current][c]){
						distance[c] = min+matrix[current][c];
					}
				}
			}
			if(current != end){ //경로가 존재하지 않으면
				System.out.println("INF");
				continue;
			}
			System.out.println(distance[end]);
		}
		
	}

}
