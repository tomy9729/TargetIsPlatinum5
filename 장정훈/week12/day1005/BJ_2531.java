package week13.day1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2531 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, d, k, c;
	//벨트에 놓여진 초밥 N, 초밥의 종류 d, 연속해서 먹을 때 할인 받는 개수 k, 쿠폰 c
	static int[] rail;//벨트에 있는 초밥을 넣는 배열
	static boolean[] dAry;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		rail = new int[N];
		for(int i=0; i<N; i++) {
			rail[i] = Integer.parseInt(br.readLine());
		}
		int max = 0;
		for(int i=0; i<N; i++) {
			dAry = new boolean[d+1];
			int sum =0;
			for(int j=i; j<k+i; j++) {
				int jj = j%N;
				if(!dAry[rail[jj]]) {
					dAry[rail[jj]] = true;
					sum++;
				}
			}
			if(!dAry[c]) {
				sum++;
			}
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}
}
