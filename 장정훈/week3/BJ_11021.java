package week3;

import java.util.Scanner;

public class BJ_11021 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int[] sum = new int[x];
 		for(int i=0; i<x; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			sum[i]= a+b;
		}
 		for(int i=0; i<sum.length; i++) {
 			System.out.printf("Case #%d: %d%n",(i+1),sum[i]);
 		}
	}

}
