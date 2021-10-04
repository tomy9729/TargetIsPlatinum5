package week10.day0916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1010 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static double[] D;
	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for(int t=0; t<TC; t++) {
			st = new StringTokenizer(br.readLine()," ");
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			D = new double[N+1];
			D[0] = 1;
			D[1] = 1;
			
			double result = (factorial(N)/(factorial(N-M)*factorial(M)));
			String str = String.format("%.0f", result);
			sb.append(str+"\n");
		}
		System.out.println(sb.toString());
	}
	private static double factorial(int n) {
		if(D[n]!=0) {
			return D[n];
		}
		for(int i=2; i<=n; i++) {
			if(D[i]!=0) continue;
			D[i] =  D[i-1]*i;
		}
		return D[n];
	}

}
