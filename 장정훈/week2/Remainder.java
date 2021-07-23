package week2;

import java.util.Scanner;

public class Remainder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int z = sc.nextInt();
		System.out.println((x+y)%z);
		System.out.println(((x%z)+(y%z))%z );
		System.out.println((x*y)%z);
		System.out.println(((x%z)*(y%z))%z);
		sc.close();
	}

}
