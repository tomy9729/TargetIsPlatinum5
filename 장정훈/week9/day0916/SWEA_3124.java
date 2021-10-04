package week10.day0916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3124 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int V,E;
	static int[][] adjMatrix;
	static boolean visited[];
	static long[] minEdge;
	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for(int t=1; t<=TC; t++) {
			st = new StringTokenizer(br.readLine()," ");
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			adjMatrix = new int[V][V];
			visited = new boolean[V];
			minEdge = new long[V];
			for(int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adjMatrix[from-1][to-1] = Integer.parseInt(st.nextToken());
				
			}
			for(int i=0; i<V; i++) {
				minEdge[i] = Long.MAX_VALUE;
			}
			long result = 0;//최소신장트리 비용
			minEdge[0] = 0;//임의의 시작점 0의 간선비용을 0으로 세팅
	
			for(int i=0; i<V; i++) {
				//1. 신장트리에 포함되지 않은 정점 중 최소 간선 비용의 정점 찾기.
				long min = Long.MAX_VALUE;
				int minVertex = -1;//최소 간선 비용의 정점 번호
				for(int j=0; j<V; j++) {
					if(!visited[j] && min>minEdge[j]) {
						min = minEdge[j];
						minVertex = j;
					}
				}
				
				visited[minVertex] = true;//신장트리에 포함시킴
				result += min; //간선 비용 누적
				//2. 선택된 정점 기준으로 신장트리에 연결되지 않은 타 정점과의 간선 비용 최소로 업데이트
				for(int j=0; j<V; j++) {
					if(!visited[j] && adjMatrix[minVertex][j] != 0 &&minEdge[j]>adjMatrix[minVertex][j]) {
						minEdge[j] = adjMatrix[minVertex][j];
					}
				}
			}
			sb.append("#"+t+" "+result);
		}
		System.out.println(sb.toString());
	}

}
