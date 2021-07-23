package week3;

import java.util.Scanner;

public class BJ_8393 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x =sc.nextInt();
		BJ_8393 s = new BJ_8393();
		System.out.println(s.sum(x));
	}
	public int sum(int x) {
		
		return x>0 ? x+sum(--x):0;
	}

}
