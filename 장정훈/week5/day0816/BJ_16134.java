package week6.day0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16134 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N,M;
	static String str1 = "";
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		System.out.println(N+"::"+M);
//		long x = combi(N*1L);
//		long y = combi(M*1L);
//		long z = combi((N-M)*1L);
		combi(str1, N);
		System.out.println(str1.length());
	}
	private static void combi(String str, long x) {
		if(x==0) {
			return;
		}
		combi(str+"1",x-1);
	}

}
