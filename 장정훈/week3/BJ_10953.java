package week3;

import java.util.Scanner;

public class BJ_10953 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		String str = "";
		int[] sum = new int[x];
		for(int i=0; i<x; i++) {
			str = sc.next();
			int a = str.charAt(0)-'0';
			int b = str.charAt(2)-'0';
			sum[i] = a+b;
		}
		for(int y:sum) {
			System.out.println(y);
		}
	}

}
