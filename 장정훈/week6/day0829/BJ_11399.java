package week7.day0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11399 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[] ary;
	static int cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		ary = new int[N];
		for(int i=0; i<N; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(ary);
		for(int i=0; i<N; i++) {
			for(int j=0; j<=i; j++) {
				cnt += ary[j];
			}
		}
		System.out.println(cnt);
	}

}
