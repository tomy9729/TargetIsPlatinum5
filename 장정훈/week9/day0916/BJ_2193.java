package week10.day0916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2193 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		System.out.println(fibo(N));
		
	}
	
	private static long fibo(int n) {
		long[] D = new long[n+1];
		D[0] = 0;
		D[1] = 1;
		for(int i=2; i<=n; ++i) {
			D[i] =  D[i-1] + D[i-2];
		}
		return D[n];
	}
}
