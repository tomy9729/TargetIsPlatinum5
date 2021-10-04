package week7.day0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DIjkstra {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int N;
	static int[][] graph;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new StringReader(src));
		for (int i = 0; i < 3; i++) {
			N = Integer.parseInt(br.readLine());
			graph = new int[N][N];
			// 그래프 구성하기
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int c = 0; c < N; c++) {
					graph[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			// 시작
			int[] dist = new int[N];
			boolean[] visited = new boolean[N];
			int[] parents = new int[N];

			// 비용 테이블 초기화
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[0] = 0;// 출발지의 비용은 항상 0

			// 정점의 개수만큼 동작.
			for (int n = 0; n < N; n++) {
				// 아직 미 방문인 지점 중 비용이 가장 작은 시점을 찾는다.
				int minV = 0;
				int minCost = Integer.MAX_VALUE;
				for (int v = 0; v < N; v++) {
					if (!visited[n] && dist[v] < minCost) {
						minCost = dist[v];
						minV = v;
					}
				} // 비용이 가장 작은 정점을 찾음.

				// 비용이 가장 적었던 정점을 찾아 방문 처리.
				visited[minV] = true;
				// 여기가 목적지인지 한 번 확인 해보자. --> 아무튼 여기에서 뭔가를 할 예정.
				if (minV == N - 1) {
					break;
				}
				// 주변 정점들을 탐색.
				for (int c = 0; c < N; c++) {
					// 미방문이고, 그래프 상 연결되어 있고, 기존 비용이 경유지를 통해서 온 비용보다 크다면
					// 갱신되는 비용 : 출발점에서 minV까지 간 비용 + minV에서 c까지 가는 비용
					if (!visited[c] && graph[minV][c] > 0
							&& dist[c] > dist[minV] + graph[minV][c]/* minV에서 C까지 가는 비용 */) {
						// 기존에 저장된 비용이 더 컸으니깐 작은 걸로 대체
						dist[c] = dist[minV] + graph[minV][c];
						// 누구에서 왔는지도 바뀜.
						parents[c] = minV;
					}
				}

			}
			System.out.println("비용 테이블: "+Arrays.toString(dist));
			System.out.println("경로 테이블: "+Arrays.toString(parents));
			int v = N-1;
			while(true) {
				int pre = parents[v];
				sb.insert(0, ">");
				sb.insert(0, pre);
				if(pre ==0) {
					break;
				}
				v = pre;
			}
			System.out.println(sb.toString());
		}
	}

	private static String src = "5\r\n"
			+ "0 2 2 5 9\r\n"
			+ "2 0 3 4 8\r\n"
			+ "2 3 0 7 6\r\n"
			+ "5 4 7 0 5\r\n"
			+ "9 8 6 5 0\r\n"
			+ "4\r\n"
			+ "0 94 53 16 \r\n"
			+ "79 0 24 18 \r\n"
			+ "91 80 0 98 \r\n"
			+ "26 51 92 0\r\n"
			+ "7\r\n"
			+ "0   2   8   5   9  15  20\r\n"
			+ "2   0   5   4   7  10  16\r\n"
			+ "8   5   0   7   6   4  10\r\n"
			+ "5   4   7   0  15   8   9\r\n"
			+ "9   7   6  15   0  11  13\r\n"
			+ "15 10   4   8  11   0   6\r\n"
			+ "20 16  10   9  13   6   0";

}
