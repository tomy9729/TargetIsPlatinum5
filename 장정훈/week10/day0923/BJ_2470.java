package week11.day0923;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2470 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] ary;
	
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		ary = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(ary);
		int result = Integer.MAX_VALUE;
		int l = 0;
		int r = N-1;
		int alkaline = 0;
		int acid = 0;
		while(l<r) {
			if(result>Math.abs(ary[l]+ary[r])) {
				result = Math.abs(ary[l]+ary[r]);
				alkaline = ary[l];
				acid = ary[r];
			}
			
			if(ary[l]+ary[r]==0) {
				//같으면 이보다 더 작을 수가 없다.
				alkaline = ary[l];
				acid = ary[r];
				break;
			}
			else if(ary[l] + ary[r] > 0) {
				//차이가 플러스면 산성이 더 강한 거니깐 전 단계의 산성을 불러온다.
				r--;
			}else if(ary[l] + ary[r] < 0) {
				//차이가 마이너스면 알칼리성이 강한 거니깐 전 단계의 알칼리성을 불러온다. 
				l++;
			}
			
		}
		System.out.println(alkaline+" "+acid);
		
		
	}
}
