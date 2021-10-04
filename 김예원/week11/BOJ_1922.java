package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Com implements Comparable<Com>{
	int s, e, v;

	public Com(int s, int e, int v) {
		super();
		this.s = s;
		this.e = e;
		this.v = v;
	}

	@Override
	public int compareTo(Com o) {
		return this.v - o.v;
	}
	
}

public class BOJ_1922 {
	static int E, V, sum;
	static int[] parent;
	static List<Com> list = new ArrayList();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		E = Integer.parseInt(br.readLine());
		V = Integer.parseInt(br.readLine());

		parent = new int[E + 1];

		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list.add(new Com(s,e,v));
		}
		
		// 1. 간선의 크기로 오름차순 정렬
		Collections.sort(list);
		
		int size = list.size();
		// 2. 정렬된 순서대로 간선 탐색
		for (int i = 0; i < size; i++) {
			Com n = list.get(i);
			// 만약 두 노드의 부모가 다르다면
			if(!isSameParent(n.s, n.e)) {
				// sum에 간선 크기 저장
				sum+=n.v;
				// 두 노드 연결
				union(n.s,n.e);
			}
			
		}
	
		System.out.println(sum);

	}

	// 간선 연결
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);

		if (a != b) {
			parent[b] = a;
		}
	}

	// 부모 노드 찾기
	private static int find(int a) {
		if (parent[a] == a) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}

	// 부모가 같은지를 판별해주는 method
	private static boolean isSameParent(int a, int b) {
		a = find(a);
		b = find(b);

		if (a == b)
			return true;
		else
			return false;
	}

}
