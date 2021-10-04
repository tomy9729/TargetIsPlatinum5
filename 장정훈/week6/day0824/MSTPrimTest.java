package week7.day0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MSTPrimTest {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int R,C;
	static int[][] adjMatrix;
	static boolean visited[];
	static int[] minEdge;
	public static void main(String[] args) throws IOException {
		R = Integer.parseInt(br.readLine());
		adjMatrix = new int[R][R];
		visited = new boolean[R];
		minEdge = new int[R];
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<R; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
			minEdge[i] = Integer.MAX_VALUE;
		}
		long result = 0;//최소신장트리 비용
		minEdge[0] = 0;//임의의 시작점 0의 간선비용을 0으로 세팅

		for(int i=0; i<R; i++) {
			//1. 신장트리에 포함되지 않은 정점 중 최소 간선 비용의 정점 찾기.
			int min = Integer.MAX_VALUE;
			int minVertex = -1;//최소 간선 비용의 정점 번호
			for(int j=0; j<R; j++) {
				if(!visited[j] && min>minEdge[j]) {
					min = minEdge[j];
					minVertex = j;
				}
			}
			visited[minVertex] = true;//신장트리에 포함시킴
			result += min; //간선 비용 누적
			//2. 선택된 정점 기준으로 신장트리에 연결되지 않은 타 정점과의 간선 비용 최소로 업데이트
			for(int j=0; j<R; j++) {
				if(!visited[j] && adjMatrix[minVertex][j] != 0 &&minEdge[j]>adjMatrix[minVertex][j]) {
					minEdge[j] = adjMatrix[minVertex][j];
				}
			}
		}
		System.out.println(result);
	}

}
