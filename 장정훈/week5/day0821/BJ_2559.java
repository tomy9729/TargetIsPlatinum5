package week6.day0821;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2559 {

	static BufferedReader br;
	static StringTokenizer st;
	static int[] num;
	static int N,K;
	
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		num = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		int Max = Integer.MIN_VALUE;
		for(int i=0; i<=N-K; i++) {
			int sum =0;
			for(int j=i; j<i+K; j++) {
				sum += num[j];
			}
			Max = Math.max(Max, sum);
		}
		System.out.println(Max);
	}

}
