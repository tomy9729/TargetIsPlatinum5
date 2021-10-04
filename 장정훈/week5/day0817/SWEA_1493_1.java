package week6.day0817;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1493_1 {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M,answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
//		System.setIn(new FileInputStream("input_SWEA1493.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=t; tc++) {
			st = new StringTokenizer(br.readLine()," ");
			int x= Integer.parseInt(st.nextToken());//(x,x)			
			int y= Integer.parseInt(st.nextToken());//(y,y)
			int[] ary1 = find(x);
			int[] ary2 = find(y);
			N = ary1[0]+ary2[0];
			M = ary1[1]+ary2[1];
			play(N,M);
			
			sb.append("#"+tc+" "+answer+"\n");
		}
		System.out.println(sb.toString());
	}


	private static int[] find(int findNum) {
		int[] ary = new int[2];
		int i=1;
		outer:while(true) {
			for(int x=1,y=i; y>=1; y--,x++) {
				if(--findNum==0) {
					ary[0] = x;
					ary[1] = y;
					break outer;
				}
			}
				
			i++;
		}
		return ary;
	}

	private static void play(int x, int y) {
		answer = 1;
		for(int c=1; c<y; c++) {
			answer += c;
		}
		for(int r=1,l=y+1; r<x; r++) {
			answer += l;
			l++;
		}
	}
}
