package week10.day0916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16917 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		int A = Integer.parseInt(st.nextToken());//양념가격
		int B = Integer.parseInt(st.nextToken());//후라이드
		int C = Integer.parseInt(st.nextToken());//반반가격
		int X = Integer.parseInt(st.nextToken());//양념 최소 마리
		int Y = Integer.parseInt(st.nextToken());//후라이드 최소 마리
		int Z = 0;//반반초기화
		
		long min = (A*X)+(B*Y)+(C*Z);//맨처음 초기화
		int cnt = Math.min(X, Y);
		if(A+B>C*2) {
			cnt = Math.max(X, Y);
		}
		for(int i=1; i<=cnt; i++) {
			X--;
			Y--;
			if(X-1<0) {
				X=0;
			}
			if(Y-1<0) {
				Y=0;
			}
			Z+=2;
			min = Math.min(min, (A*X)+(B*Y)+(C*Z));
		}
		System.out.println(min);

	}
}
