package week3;

import java.util.Scanner;

public class BJ_1330 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		if(x<y) {
			System.out.println("<");
		}else if(x>y) {
			System.out.println(">");
		}else if(x==y) {
			System.out.println("==");
		}
	}

}
