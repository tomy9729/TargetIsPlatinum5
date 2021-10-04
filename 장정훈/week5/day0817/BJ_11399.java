package week6.day0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11399 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[] ary;
	static int N;
	static boolean[] isSelected;
	static int[] num;
	static int Min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		ary = new int[N];
		for(int i=0; i<N; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
		}
		isSelected = new boolean[N];
		num = new int[N];
		Min = 0;
		Arrays.sort(ary);
		for(int i=0; i<N; i++) {
			for(int j=0; j<=i; j++) {
				Min += ary[j];
			}
		}
		System.out.println(Min);
	}


	

}
