package week2;

import java.util.Scanner;

public class BJ_2438 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		for(int i=1; i<x+1; i++) {
			for(int j=x-i; j>0; j--) {
				System.out.printf(" ");
			}
			for(int j=0; j<i; j++) {
				System.out.printf("*");
			}
			System.out.println("");
		}
		sc.close();
	}

}
