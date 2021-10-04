package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_9372 {

	static int E,V, length;
	static int [] parent;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int tc = 0;tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			E = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());
			
			parent = new int[E+1];
			length = 0;
			for(int i=0;i<parent.length;i++) {
				parent[i]=i;
			}
			
			for(int i=0;i<V;i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				
				// 부모가 같지 않다면
				if(!isSameParent(s, e)) {
					// 간선을 연결하고 간선 수 +1
					length++;
					// 두 노드 합치기
					union(s,e);
				}
				
				// 부모가 같으면 어떠한 동작도 하지 않고 다음으로 넘어감
				
			}
			
			System.out.println(length);
		}

	}
	// 간선 연결
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a != b) {
			parent[b] = a;
		}
	}
	// 부모 노드 찾기 
	private static int find(int a) {
		if(parent[a] == a) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}
	// 부모가 같은지를 판별해주는 method
	private static boolean isSameParent(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a==b) return true;
		else return false;
	}
}
