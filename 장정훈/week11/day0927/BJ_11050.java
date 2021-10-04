package week12.day0927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11050 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] DP;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		DP = new int[N+1];
		DP[0] = 1;
		DP[1] = 1;
		int result = fact(N) / (fact(N-K)*fact(K));
		System.out.println(result);
	}

	private static int fact(int n) {
		if(DP[n]!=0) {
			return DP[n];
		}
		return DP[n] = fact(n-1) * n;
	}
}
