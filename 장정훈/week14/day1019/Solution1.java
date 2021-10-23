package week15.day1019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1 {

	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[] arr;
	static boolean[] select;
	static int Max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			select = new boolean[N];
			Max = 0;
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			combi(0,0);
			
			sb.append("#"+t+" "+Max+"\n");
		}
		System.out.println(sb.toString());
	}

	private static void combi(int cnt, int idx) {
		if(cnt == 4) {
			play();
		}
		
		for(int i=idx; i<N; i++) {
			select[i] = true;
			combi(cnt+1,i+1);
			select[i] = false;
		}
		
		
	}

	private static void play() {
		int[] extra = new int[6];
		int cnt = 1;
		for(int i=0; i<N; i++) {
			if(select[i]) {
				extra[cnt++] = i;
			}
		}
		extra[0] = extra[4];
		extra[5] = extra[1];
		for(int i=1; i<5; i++) {
			if(extra[i]==0) {
				if(extra[i-1]==(N-1) || extra[i+1] == extra[i]+1) {
					return;
				}
			}else if(extra[i]==N-1) {
				if(extra[i-1]==extra[i]-1 || extra[i+1]==0) {
					return;
				}
			}else{
				if(extra[i-1] == extra[i]-1 || extra[i]+1 == extra[i+1]) {
					return;
				}
			}
		}
		int[] jin = new int[4];
		for(int i=0; i<4; i++) {
			jin[i] = extra[i+1];
		}
//		System.out.println(Arrays.toString(jin));
		int A = (int)(Math.pow(arr[jin[0]]+arr[jin[1]],2) + Math.pow(arr[jin[2]]+arr[jin[3]],2));
		int B = (int)(Math.pow(arr[jin[0]]+arr[jin[3]],2) + Math.pow(arr[jin[1]]+arr[jin[2]],2));
		Max = Math.max(Max, Math.max(A, B));
	}


}
