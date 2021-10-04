package week12.day0929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5604_review {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static long A,B;
	static long[] cnts;
	static long delta = 1;
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			long result=0;
			st = new StringTokenizer(br.readLine()," ");
			A = Long.parseLong(st.nextToken());
			B = Long.parseLong(st.nextToken());
			cnts = new long[10];
			delta = 1;
			while(A<=B) {
				
				for(; A%10!=0 && A<=B; A++) {
					parse(A,delta);
				}
				for(; B%10!=9 && A<=B; B--) {
					parse(B,delta);
				}
				if(A>B) {
					break;//모든 숫자가 한 줄에 위치할 때
				}
				A/=10;
				B/=10;
				long rowCnt = B-A+1;
				for(int i=0; i<10; i++) {
					cnts[i] += delta*rowCnt;
				}
				delta*=10;
			}
			for(int i=1; i<10; i++) {
				result += i*cnts[i];
			}
			
			sb.append("#"+t+" "+result+"\n");
		}
		System.out.println(sb.toString());
	}

	private static void parse(long x,long d) {
		
		while(x>0) {
			cnts[(int) (x%10)] += delta;
			x/=10;
		}
	}
}
