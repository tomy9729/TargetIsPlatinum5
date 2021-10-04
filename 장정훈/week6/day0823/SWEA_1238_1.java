package week7.day0823;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
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
	static boolean[] visited;
	static Queue<int[]> Q;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input_SWEA1238.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			Start = Integer.parseInt(st.nextToken());
			MAP = new boolean[101][101];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				MAP[to][from] = true;
			}
			Max = Integer.MIN_VALUE;
			visited = new boolean[101];
			Q = new LinkedList<>();
			bfs(Start,1);
			find();
			sb.append("#" + tc + " " + Max + "\n");
		}
		System.out.println(sb.toString());
	}

	private static void bfs(int number,int cnt) {

		
		visited[number] = true;
		
		for(int i=1; i<101; i++) {
			if(!visited[i] && MAP[number][i]) {
				Q.add(new int[] {i,cnt});
				bfs(i,cnt+1);
			}
		}
		

	}

	private static void find() {
		int size = Q.size();
		int m = 0;//cnt 확인
		
		for(int i=0; i<size; i++) {
			int[] arr = Q.poll();
			if(m<=arr[1]) {
				m=arr[1];
				Max = Math.max(Max, arr[0]);
			}
		}
		
	}

}
