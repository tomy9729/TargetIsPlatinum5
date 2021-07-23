package week3;

import java.util.Scanner;

public class BJ_11720 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		String str = sc.next();
		int sum=0;
		for(int i=0; i<x; i++) {
			sum += str.charAt(i)-'0';
		}
		System.out.println(sum); 
		
	}

}
