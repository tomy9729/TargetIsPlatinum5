package week6.day0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SquareNumber {

	static int callCnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
//		System.out.println(exp1(x,y));
		System.out.println(exp2(x,y));
		System.out.println(callCnt);
		
	}
	static long exp1(long x, long y) {
		
		callCnt++;
		if(y==1)return x;
		return x*exp1(x,y-1);
	}
	
	static long exp2(long x,long y) {//분할 정복
		callCnt++;
		if(y==1) return x;
		long r = exp2(x,y/2);
		long res = r * r;
		if(y%2==1) {//홀수 일 때는 한 번 더 곱하기
			res *= x;
		}
		return res;
	}
}
