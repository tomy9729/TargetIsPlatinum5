package week10.day0916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2193_1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static long[][] DP;
	
	public static void main(String[] args) throws IOException {
		
		int N = Integer.parseInt(br.readLine());
		DP = new long[N+1][2];//1~N까지 0혹은 1일 때의 가능한 값 저장
		DP[1][0] = 0;
		DP[1][1] = 1;
		
		for(int i=2; i<=N; i++) {
			for(int n=0; n<2; n++) {
				if(n==0) {
					DP[i][n] = DP[i-1][0] + DP[i-1][1];
				}//새로 나오는 값이 0이면 앞에 뭐가 있든 붙일 수 있다.
				else {
					DP[i][n] = DP[i-1][0];
				}//새로 들어갈 값이 1이면 앞에 1일 때는 들어가면 안 된다.
			}
		}
		System.out.println(DP[N][0]+DP[N][1]);
	}
}
