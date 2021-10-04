package week10.day0916;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1263 {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] MAP;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input_SWEA1263.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		for(int t=1; t<=TC; t++) {
			st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int INF = (N*(N+1))/2+1;
			MAP = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(i==j) {
						st.nextToken();
						MAP[i][j] = 0;
						continue;
					}
					MAP[i][j] = Integer.parseInt(st.nextToken());
					if(MAP[i][j]==0) {
						MAP[i][j] = INF;
					}
				}
			}
			
			for (int k = 0; k < N; k++) {//경
				for (int i = 0; i < N; i++) {//출
					for (int j = 0; j < N; j++) {//도
						MAP[i][j] = Math.min(MAP[i][j], MAP[i][k]+MAP[k][j]);
					}
				}
			}//이거 순서 바꾸면 속도 느려짐?
			int min = INF;
			
			for(int i=1; i<N; i++) {
				int sum =0;
				for(int j=0; j<N; j++) {
					sum += MAP[i][j];
				}
				min = Math.min(min, sum);
			}
			
			
			sb.append("#"+t+" "+min+"\n");
		}
		System.out.println(sb.toString());
	}
}
