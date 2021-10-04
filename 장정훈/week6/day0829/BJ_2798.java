package week7.day0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2798 {
	//N개 중 3개를 고르는 조합.
		
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] ary;
	static int[] answer;
	static int N,M;
	static int Max;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine()," ");
		ary = new int[N];
		answer = new int[3];
		Max = Integer.MIN_VALUE;
		for(int i=0; i<N; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
		}
		combi(0,0);
		System.out.println(Max);
	}
	private static void combi(int cnt, int idx) {
		if(cnt == 3) {
			int sum=0;
			for(int i=0; i<3; i++) {
				sum += answer[i];
			}
			if(sum<=M) {
				Max = Math.max(Max, sum);
			}
			return;
		}
		for(int i=idx; i<N; i++) {
			answer[cnt] = ary[i];
			combi(cnt+1, i+1);
		}
	}

}
