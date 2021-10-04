package week6.day0817;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1493 {
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
			N = 1;
//			int temp = x;
//			x = x + y;
//			y = temp + y;
			
				for(int c=1; c<y; c++) {
					N += c;
				}
				for(int r=1,l=y+1; r<x; r++) {
					N += l;
					l++;
				}
			
			
			
			sb.append("#"+tc+" "+N+"\n");
		}
		System.out.println(sb.toString());
	}

}
