package week10.day0914;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_Q2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] CM;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		CM = new int[n+1];
		CM[0] = 1;//아무것도 안 쓰는 방법 한 가지 방법
		CM[1] = 2;//노란 막대 혹은 파란 막대를 쓰는 두 가지 방법
//		CM[2] = 5;//2^n + 1;
//		CM[3] = 12;//CM[2]*2 +2;
//		CM[4] = 29;//CM[3]*2 +5;
		for(int i=2; i<=n; i++) {
			CM[i] = CM[i-1]*2 + CM[i-2];
		}
		System.out.println(CM[n]);
	}

}
