package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Edge{
	int end;
	int value;
	
	public Edge(int end, int value) {
		super();
		this.end = end;
		this.value = value;
	}

}



public class BOJ_1753_2 {

	static int vertex, edge, k;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		vertex = Integer.parseInt(st.nextToken());
		edge = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(br.readLine());
		
		int[] distance = new int[vertex+1];
		
		// 도착하지 못하면 INF
		boolean[] visited = new boolean[vertex + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		// index by index 배열로 했더니 메모리 초과 나서 ArrayList로 바꿈.
		ArrayList<Edge>[] list = new ArrayList[vertex + 1];
		for (int i = 0; i <= vertex; i++) {
            list[i] = new ArrayList<Edge>();
        }
		for(int i=0;i<edge;i++) {
			st = new StringTokenizer(br.readLine());
			list[Integer.parseInt(st.nextToken())].add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		// 우선순위 큐 사용(성능이 좋아짐)
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		
		// 시작점 K, K-K는 0
		q.add(k);
		distance[k]=0;
		while(!q.isEmpty()) {
			// 다음 방문할 vertex
			int current = q.poll();
			
			visited[current] = true;
			
			for(int i=0;i<list[current].size();i++) {
				// 현재 vertex에서 다음 vertex를 차근차근 비교해서 우선순위 큐에 넣는다.
				int next = list[current].get(i).end; // 다음 vertex
				int value = list[current].get(i).value; // 현재  = 다음 간 edge값
				
				
				// 이전에 있던 값이 더 크다면 굳이 다시 방문할 필요가 없다. 이미 그 전이 더 최단 경로 
				if(distance[next] > distance[current]+value) {
					distance[next] = Math.min(distance[next], value+distance[current]);
					q.add(next);
				}
			}
			
			
		}
		
		// 출력
		for(int i=1;i<=vertex;i++) {
			if(visited[i]) {
				System.out.println(distance[i]);
			}else System.out.println("INF");
		}
		
		
		
		
	}

}
