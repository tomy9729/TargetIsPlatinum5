package week10.day0916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_3124_kruskal {

	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int V, E;
	static Edge[] edgeList;
	static int[] parents; // 부모원소를 관리

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			edgeList = new Edge[E];

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				edgeList[i] = new Edge(start - 1, end - 1, weight);
			}

			Arrays.sort(edgeList);
			make();// 모든 정점을 각각의 집합으로 만들고 출발
			long cnt = 0, result = 0;
			for (Edge e : edgeList) {
				if (union(e.start, e.end)) {
					result += e.weight;
					if (++cnt == V - 1)
						break; // 신장트리 완성
				}
			}
//		System.out.println(result);
			sb.append("#" + t + " " + result+"\n");
		}
		System.out.println(sb.toString());
	}

	private static void make() {
		parents = new int[V];
		// 모든 원소를 자신을 대표자로 만듦
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}

	private static int find(int a) {
		// a가 속한 집합의 대표자 찾기
		if (a == parents[a])
			return a;

		return parents[a] = find(parents[a]);// 자신이 속한 집합의 대표자를 자신의 부모로 : path compression
	}

	private static boolean union(int a, int b) {
		// 두 원소를 하나의 집합으로 합치기(대표자를 이용해서 합침);
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot)
			return false;// 이미 같은 집합으로 합치지 않음.

		parents[bRoot] = aRoot;
		return true;

	}

	static class Edge implements Comparable<Edge> {
		int start, end, weight;

		public Edge(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
//			return this.weight-o.weight;//간선의 부호가 모두 같을 떄 사용 하고
			return Integer.compare(this.weight, o.weight);// 다를 수 있을 때 사용
		}

	}

}
