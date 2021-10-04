package week7.day0824;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class SWEA_1238_1 {

	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, Start;
	static int Max;
	static boolean[][] MAP;
	static int[] visited;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input_SWEA1238.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			Start = Integer.parseInt(st.nextToken());
			MAP = new boolean[101][101];
			Max = Integer.MIN_VALUE;
			visited = new int[101];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				MAP[from][to] = true;
			}
			
			
			bfs(Start);
			
			sb.append("#" + tc + " " + Max + "\n");
		}
		System.out.println(sb.toString());
	}

	private static void bfs(int start) {
		
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.add(start);
		visited[start]=1;
		int cnt =1;
		while(!Q.isEmpty()) {
			int current = Q.poll();
			
			for(int i=1; i<101; i++) {
				if(MAP[current][i] && visited[i]==0) {
					visited[i] = visited[current]+1;
					Q.offer(i);
				}
			}
			cnt = visited[current];
		}
		
		for(int i=1; i<101; i++) {
			if(cnt==visited[i]) {
				Max = Math.max(Max, i);
			}
		}
		
	}

	

}
