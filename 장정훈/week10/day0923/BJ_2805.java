package week11.day0923;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2805 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] ary;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ary = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(ary);
		int l = 1;//최소가 1;
		int r = ary[N-1];//최대
		int m = 0;
		long sum=0;
		while(l <= r) {
			m = (l+r)/2;
			int cut =0;
			sum=0; 
			for(int i=0; i<N; i++) {
				cut = ary[i] - m;
				if(cut<0) {
					cut=0;
				}
				sum += cut;
			}
			if(sum>=M) {
				l = m + 1;
			}else if(sum<M) {
				r = m - 1;
			}
		}
		System.out.println(r);//높이의 최댓값
	}
}
