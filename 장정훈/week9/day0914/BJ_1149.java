package week10.day0914;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1149 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] bills;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		bills = new int[N+1][3];//빨초파
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			bills[i][0] = Integer.parseInt(st.nextToken())+Math.min(bills[i-1][1], bills[i-1][2]);
			bills[i][1] = Integer.parseInt(st.nextToken())+Math.min(bills[i-1][0], bills[i-1][2]);
			bills[i][2] = Integer.parseInt(st.nextToken())+Math.min(bills[i-1][0], bills[i-1][1]);
			
		}
		
		int min = bills[N][0];//Integer.MAX_VALUE;
		for(int i=1; i<3; i++) {
//			if(min>bills[N][i]) {
//				min = bills[N][i];
//			}//92ms;
			min = Math.min(bills[N][i],min);//88ms
		}
		
		System.out.println(min);
//		System.out.println(Math.min(bills[N][0], Math.min(bills[N][1], bills[N][2])));//100ms이게 더 느림
		
	}

}
