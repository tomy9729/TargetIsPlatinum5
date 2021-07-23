package week3;

import java.util.Scanner;

public class BJ_2588 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		System.out.println(x*(y%10));
		System.out.println(x*((y/10)%10));
		System.out.println(x*(y/100));
		System.out.println(x*y);
	}

}
