package week7.day0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1753 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int V,E;
	static int[][] Map;
	static int Start;
	static int[] distance;
	static boolean[] visited;
	
	static final int INFINITY = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		Map = new int[V+1][V+1];
		Start = Integer.parseInt(br.readLine());
		for(int e=0; e<E; e++) {
			st = new StringTokenizer(br.readLine()," ");
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			Map[i][j] = w;
		}
		distance = new int[V+1];
		visited = new boolean[V+1];
		Arrays.fill(distance, INFINITY);
		distance[Start] = 0;
		int min=0, current=0;
		for(int i=1; i<V+1; ++i){
			//a단계 : 방문하지 않은 정점들 중 최소가중치의 정점 선택
			min = INFINITY;
			for(int j=1; j<V+1; ++j){
				if(!visited[j] && distance[j] < min){
					min = distance[j];
					current = j;
				}
			}
			visited[current] = true; // 선택 정점 방문 처리
			//b단계: current정점을 경유지로 하여 갈수 있는 다른 방문하지 않은 정점들에 대한 처리
			for(int c=1; c<V+1; ++c){
				if(!visited[c] && Map[current][c] != 0
						&&  distance[c] > min+Map[current][c]){
					distance[c] = min+Map[current][c];
				}
			}
		}
		for(int i=1; i<V+1; i++) {
			if(distance[i] == INFINITY) {
				sb.append("INF\n");
				continue;
			}
			sb.append(distance[i]+"\n");
		}
		System.out.println(sb.toString());
	}

}
