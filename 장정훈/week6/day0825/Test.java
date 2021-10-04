package week7.day0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static double N, M;
	static double boo;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//골판지의 가로 세로가 주어질 때 최대 부피를 구하라
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Double.parseDouble(st.nextToken());
			M = Double.parseDouble(st.nextToken());
			boo = 0.0;
			
//			double h = (1/(double)3*(N+M)-Math.pow((-1*((N+M)/3)),(double)2) - Math.pow((N*M)/3,1/(double)2))/ (double)2;
			double h = ((N+M)/3 - Math.pow((Math.pow(((N+M)/3)*-1, 2) - (N*M/3)),1/(double)2))/2;
			System.out.println(h);
			double a = N - 2*h;
			double b = M - 2*h;
			boo = (double)a*b*h;
			
			sb.append("#"+t+" "+String.format("%.6f", boo)+"\n");
//			System.out.printf("#%d %f%n",t,boo);
		}
		System.out.println(sb.toString());
	}

}
