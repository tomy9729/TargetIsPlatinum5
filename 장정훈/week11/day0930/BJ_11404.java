package week12.day0930;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11404 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int M;
	static long[][] map;
	
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		map = new long[N][N];
		//경출도
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i==j) continue;
				map[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int A = Integer.parseInt(st.nextToken())-1;
			int B = Integer.parseInt(st.nextToken())-1;
			int distance = Integer.parseInt(st.nextToken());
			map[A][B] = Math.min(map[A][B], distance);//연결하는 노선은 하나가 아닐 수 있다.
		}
		
		floyd();
		
		for(long[] arr:map) {
			for(long a : arr) {
				if(a==Integer.MAX_VALUE) {
					sb.append("0 ");
				}else {
					sb.append(a+" ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}


	private static void floyd() {
		for(int l=0; l<N; l++) {
			for(int i=0; i<N; i++) {
				
				for(int j=0; j<N; j++) {
					
					map[i][j] = Math.min(map[i][j], map[i][l]+map[l][j]);
				}
			}
		}
		
	}
}
