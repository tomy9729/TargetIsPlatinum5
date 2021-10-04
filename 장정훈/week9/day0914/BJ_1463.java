package week10.day0914;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1463 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] info;
	static int cnt =0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		info = new int[N+1];
		info[1] = 0;
		
		for(int i=2; i<=N; i++) {
			int a = info[i-1]+1;
			int b = Integer.MAX_VALUE;
			int c = Integer.MAX_VALUE;
			if(i%3==0) {
				b = info[i/3]+1;
			}
			if(i%2==0) {
				c = info[i/2]+1;
			}
			info[i] = Math.min(Math.min(b, c),a);//b c 조건에 맞춰진 값이 중 하나는 MAX일 수 있다.
		}
		
		System.out.println(info[N]);
	}
	/*private static int play(int n) {
		if(n==1) {
			return 0;
		}
		if(info[n]>0) {
			return info[n];
		}
		info[n] = play(n-1)+1;
//		
		if(n%3==0) {
			info[n] = Math.min(info[n], play(n/3)+1);
		
		}
		if(n%2==0) {
			info[n] = Math.min(info[n], play(n/2)+1);
		}
		return info[n];
	}*/

}
