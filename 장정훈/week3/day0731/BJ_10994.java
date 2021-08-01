package week3.day0731;

import java.util.Scanner;

public class BJ_10994 {
	public static int N;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		N=n;
		for(int i=n; i>1; i--){
			print(i);
			print4(N-i);
			System.out.println();
			print2(i);
			System.out.println("");
			print3(i);
		}
		print(1);
		for(int i=1; i<n; i++){
			print5(i);
			System.out.println();
			print2(i+1);
			System.out.println("");
			print3(i+2);
			print(i+1);
//			
			
		}
//		println();
	}
	public static void print(int i) {
		int x = (5*(i-1)-(i-2));
		int y = (5*((i-1)-1)-((i-1)-2));
		if(i == 1) {
			System.out.printf("*");
		}else {
		
			for(int l=x; l>0; l--) {
				System.out.printf("*");
			}
//			print4(i);
//			System.out.printf("*");
//			for(int l=x-2; l>0; l--) {
//				System.out.printf(" ");
//			}
//			System.out.printf("*");
//			System.out.println();
			
//			for(int l=i-1; l<N; l++) {
//				System.out.printf(" *");
//			}
			
			
			//System.out.printf("%d",i);
		
		}
	}
	public static void print2(int i) {
		int y = (5*((i-1)-1)-((i-1)-2));
		for(int l=i-1; l<N; l++) {
			System.out.printf("* ");
		}
		for(int l=0; l<y; l++) {
			System.out.printf(" ");
		}
		for(int l=i-1; l<N; l++) {
			System.out.printf(" *");
		}
	}
	public static void print3(int i) {
		for(int l=i-1; l<N; l++) {
			System.out.printf("* ");
		}
	}
	public static void print4(int i) {
		for(int l=0; l<i; l++) {
			System.out.printf(" *");
		}
	}
	public static void print5(int i) {
		for(int l=i; l<N; l++) {
			System.out.printf(" *");
		}
	}

}
