package week11.day0923;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1697 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,K;
	static int[] map;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[100001];
		if(N==K) {
			System.out.println(0);
		}else {
			System.out.println(bfs());
		}
	}

	private static int bfs() {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(N);
		map[N] = 1;//map에 0을 활용하기 위해
		while(!q.isEmpty()) {
			int next = q.poll();
			if(next==K) {
				return map[next]-1;
			}
			if(next-1 >=0 && map[next-1]==0) {
				map[next-1] = map[next]+1;
				q.add(next-1);
			}
			if(next+1 <=100000 && map[next+1]==0) {
				map[next+1] = map[next]+1;
				q.add(next+1);
			}
			if(next*2 <=100000 && map[next*2]==0) {
				map[next*2] = map[next]+1;
				q.add(next*2);
			}
		}
		
		return 0;
	}
}
