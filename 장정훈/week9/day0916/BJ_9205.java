package week10.day0916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_9205 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for(int t=0; t<TC; t++) {
			int N = Integer.parseInt(br.readLine());
			map = new int[N+2][N+2];
			//20 - (맨해튼 거리/50);
			//맨해튼 거리가 최소인 곳을 찾아서 간다.
			//입력을 먼저 받고, 받은 값
			List<int[]> list = new ArrayList<>();
			for(int i=0; i<N+2; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int c = Integer.parseInt(st.nextToken());//x니깐 가로
				int r = Integer.parseInt(st.nextToken());//y니깐 높이
				list.add(new int[] {c,r});
			}
			for(int i=0; i<N+2; i++) {
				for(int j=0; j<N+2; j++) {//i+1 다음 위치부터
					int[] arr1 = list.get(i);
					int[] arr2 = list.get(j);
					map[i][j] = Math.abs(arr1[0]-arr2[0])+Math.abs(arr1[1]-arr2[1]);
					if(map[i][j]>1000) {
						map[i][j]=-1;
					}
				}
			}

			for (int k = 0; k < N+2; k++) {//경
				for (int i = 0; i < N+2; i++) {//출
					
					for (int j = 0; j < N+2; j++) {//도
						
						if(map[i][k]==-1||map[k][j]==-1) {
							continue;
						}
						map[i][j] = 1;//Math.max(map[i][j], map[i][k]+map[k][j]);
					}
				}
			}

			if(map[0][N+1]==-1) {
				sb.append("sad\n");
			}else{
				sb.append("happy\n");
			}
		}
		System.out.println(sb.toString());
	}
}
