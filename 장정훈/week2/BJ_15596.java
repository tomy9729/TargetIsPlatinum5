package week2;

import java.util.Scanner;

public class BJ_15596 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		BJ_15596_TestClass test = new BJ_15596_TestClass();
		int[] a = new int[x];
		for(int i=0; i<x; i++){
			a[i] = sc.nextInt();
		}
		long res = test.sum(a);
		System.out.println(res);
		sc.close();
	}
	
	

}
