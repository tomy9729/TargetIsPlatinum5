package week16.day1104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_18352 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M, K, start;
	static int[] cur;//start에서의 거리 배열
	static List<Point>[] info;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		
		cur = new int[N+1];
		info = new ArrayList[N+1];
		for(int i=1; i<N+1; i++) {
			info[i] = new ArrayList<>();
		}
		Arrays.fill(cur, Integer.MAX_VALUE);
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			info[from].add(new Point(to, 1));
			
		}
		
		dijkstra();
		
		
		boolean flag = false;
		for(int i=1; i<N+1; i++) {
			if(cur[i] == K) {
				sb.append(i+"\n");
				flag=true;
			}
		}
		
		if(flag) {
			System.out.println(sb.toString());
		}else {
			System.out.println("-1");
		}
		
	}
	
	private static void dijkstra() {
		PriorityQueue<Point> PQ = new PriorityQueue<>();
		PQ.offer(new Point(start, 0));
		cur[start] = 0;
		while(!PQ.isEmpty()) {
			Point now = PQ.poll();
			
			
			
			for(int i=0; i<info[now.point].size(); i++) {
				Point next = info[now.point].get(i);
				
				if(now.dis+next.dis < cur[next.point]) {
					cur[next.point] = now.dis+next.dis;
					PQ.offer(new Point(next.point, now.dis+next.dis));
				}
				
				
				
				
			}
			
		}
		
	}

	static class Point implements Comparable<Point>{
		int point;
		int dis;
		
		public Point(int point, int dis) {
			super();
			this.point = point;
			this.dis = dis;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.dis, o.dis);
		}
		
		
		
	}
}
