package week15.day1029;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NHN3 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M,K;
	static int[][] map;
	static int Max;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M+1];
		arr = new int[N];
		Max = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0);
		System.out.println(Max);
	}

	private static void dfs(int r, int cnt) {
		if(cnt==K) {
			Max = Math.max(Max, sum());
			return;
		}
		
		for(int i=r; i<N; i++) {
			if(arr[i]<M-1) {
				arr[i]++;
				dfs(i,cnt+1);
				arr[i]--;
			}
			
		}
		
	}

	private static int sum() {
		for(int i=0; i<N; i++) {
			map[i][M] = 0;
		}
		for(int i=0; i<N; i++) {
			map[i][M] = map[i][M-arr[i]];
		}
		int sum=0;
		for(int i=0; i<N; i++) {
			sum += map[i][M];
		}
		
		return sum;
	}
}
