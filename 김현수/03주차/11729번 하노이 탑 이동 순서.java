//11729번 하노이 탑 이동 순서.java
package com.ssafy.recur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hanoi {
	private static int n;
	private static int c=0;
	private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		c = count(n);		
		System.out.println(c);
		
		hanoi(n,1,2,3);
		System.out.println(sb.toString());
	}
	public static void hanoi(int n, int s, int t, int d) {
		if(n==0) return;
		hanoi(n-1,s,d,t);
		sb.append(s).append(" ").append(d).append("\n");
		hanoi(n-1,t,s,d);
	}
	public static int count(int n) {
		if(n==1) {
			return 1;
		}
		else {
			return 2*count(n-1)+1;
		}
	}
}
