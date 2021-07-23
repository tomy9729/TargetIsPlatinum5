package week3;

import java.util.Scanner;

public class BJ_10951 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			System.out.println(x+y);
		}
		sc.close();
	}

}
