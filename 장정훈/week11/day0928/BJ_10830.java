package week12.day0928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10830 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T = 1000;
	static int[][] m;
	static int N;
	static long B;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());
		m = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				m[i][j] = Integer.parseInt(st.nextToken())%T;
			}
		}
		int[][] mm = matrix(m,B);//재귀
//		int[][] mm = matrix(B);//반복문
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(mm[i][j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	private static int[][] matrix(int[][] map, long y) {
		if(y == 1) {
			return map;
		}
		int[][] res = matrix(map, y/2);
		
		res = mul(res,res);
		
		if(y%2==1) {
			res = mul(res,m);
		}
		
		return res;
	}//재귀형태

	private static int[][] matrix(long y) {

		int[][] res = new int[N][N];
		for(int i=0; i<N; i++){
			res[i][i] = 1;
		}
		while(y>0) {
			if(y%2==1) {
				res = mul(res,m);
			}
			y/=2;
			m = mul(m,m);
		}
		
		return res;
	}//반복문형태
	
	private static int[][] mul(int[][] r, int[][] x) {
		int[][] res = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				
				for(int l=0; l<N; l++) {
					res[i][j] += r[i][l]*x[l][j];
					res[i][j] %= T;
				}
			}
		}
		return res;
	}
}
