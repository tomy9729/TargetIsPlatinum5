package week12.day0930;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_6118 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static List<Integer>[] listAry;
	static PriorityQueue<Node> PQ;
	static int[] ary;
	static int find, dis, same;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ary = new int[N+1];
		listAry = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			listAry[i] = new ArrayList<>();
		}
		Arrays.fill(ary, Integer.MAX_VALUE);
		ary[1] = 0;
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			listAry[A].add(B);
			listAry[B].add(A);
		}
		
		play();
		
		for(int i=2; i<=N; i++) {
			if(dis<ary[i]) {
				find = i;
				dis = ary[i];
				same = 1;
			}else if(dis == ary[i]) {
				same++;
			}
		}
		System.out.printf("%d %d %d",find,dis,same);
	}
	
	
	private static void play() {
		PQ = new PriorityQueue<>();
		PQ.offer(new Node(1, 0));
		
		while(!PQ.isEmpty()) {
			Node now = PQ.poll();
			
			if(ary[now.Num] < now.dis)
				continue;
			
			for(int i=0; i<listAry[now.Num].size(); i++) {
				int next = listAry[now.Num].get(i);
				int tmp = now.dis +1;
				if(ary[next] > tmp) {
					ary[next] = tmp;
					PQ.offer(new Node(next, tmp));
				}
			}
		}
		
	}


	static class Node implements Comparable<Node>{
		int Num;
		int dis;
		
		
		
		public Node(int num, int dis) {
			super();
			Num = num;
			this.dis = dis;
		}



		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.dis, o.dis);
		}
		
		
		
	}
}
