package week2;

import java.util.Scanner;

public class BJ_2739 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		for(int i=1; i<10; i++) {
			System.out.printf("%d * %d = %d%n",x,i,x*i);
		}
	}

}
