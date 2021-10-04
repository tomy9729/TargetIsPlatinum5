package week6.day0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_9229 {

	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int N,M;//과자 봉지 수, 최대 무게
	static int Max;
	static int[] ary;
	static int[] sum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=t; tc++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			Max = Integer.MIN_VALUE;
			ary = new int[N];
			st = new StringTokenizer(br.readLine()," ");
			for(int n=0; n<N; n++) {
				ary[n] = Integer.parseInt(st.nextToken());
			}
			sum = new int[2];
			combi(0,0);
			if(Max == Integer.MIN_VALUE) {
				Max = -1;
			}
			sb.append("#"+tc+" "+Max+"\n");
		}
		System.out.println(sb.toString());

	}
	private static void combi(int cnt, int idx) {
		if(cnt == 2) {
			play(sum);
			return;
		}
		for(int i=idx; i<N; i++) {
			sum[cnt] = ary[i];
			combi(cnt+1,i+1);
		}
		
	}
	private static void play(int[] sum2) {
		int sum=0;
		for(int i=0; i<sum2.length; i++) {
			sum += sum2[i];
		}
		if(sum<=M) {
			Max = Math.max(Max, sum);
		}
		
	}

}
