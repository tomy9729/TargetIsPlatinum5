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
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_1238 {

	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] mm;
	static int N, Start;
	static int Max;
	static boolean[] visited;
	static List<Map> list;
	static Map[] map;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input_SWEA1238.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			Start = Integer.parseInt(st.nextToken());
			Max = Integer.MIN_VALUE;
			mm = new int[101][101];
			visited = new boolean[101];
			list = new ArrayList<Map>();
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N / 2; i++) {
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
//				list.add(e)
//				mm[i] = new Map(r,c);
				mm[r][c] = 1;
				System.out.println(r+"--"+c);
			}
			find(Start,1);
			Collections.sort(list);
			sb.append("#"+tc+" "+list.get(0).number+"\n");
		}
		System.out.println(sb.toString());
	}

	private static void find(int st,int cnt) {
		
		visited[st] = true;
		list.add(new Map(st,cnt));
		for(int i=1; i<101; i++) {
			if(mm[st][i] !=1) continue;
			if(visited[i]) continue;
			mm[st][i] += cnt;
//			Max = Math.max(Max, i);
			
			
			find(i,cnt+1);
		}
		
	}
	static class Map implements Comparable<Map>{
		int number,cnt;

		/**
		 * @param number
		 * @param cnt
		 */
		public Map(int number, int cnt) {
			super();
			this.number = number;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Map o) {
			if(this.cnt == o.cnt) {
				return (this.number - o.number)*-1;
			}
			return (this.cnt - o.cnt)*-1;
		}
		
		
		
	}

}
