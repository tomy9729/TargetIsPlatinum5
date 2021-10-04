package week6.day0819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_6603 {

	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] ary;
	static int[] selectAry;
	static int N;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		while(pick()) {
			Arrays.sort(ary);
			selectAry = new int[6];
			combi(0,0);
			sb.append("\n");
//			System.out.println(Arrays.toString(ary));
		}
		System.out.println(sb.toString());
	}

	private static void combi(int cnt, int idx) {
		if(cnt==6) {
			play(selectAry);
			
			return;
		}
		for(int i=idx; i<N; i++) {
			selectAry[cnt] = ary[i];
			combi(cnt+1,i+1);
		}
		
	}

	private static void play(int[] arr) {
		for(int i=0; i<6; i++) {
			sb.append(arr[i]+" ");
		}
		sb.append("\n");
		
	}

	private static boolean pick() throws IOException {
		boolean flag = true;
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		if(N==0) {
			flag = false;
		}else {
			ary = new int[N];
			
			for(int i=0; i<N; i++) {
				ary[i] = Integer.parseInt(st.nextToken());
			}
		}
		
		return flag;
	}

}
