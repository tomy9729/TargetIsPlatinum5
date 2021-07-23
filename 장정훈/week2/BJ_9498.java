package week2;

import java.util.Scanner;

public class BJ_9498 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
		char x = 'F';
		score = score / 10;
		switch (score) {
		case 9:
		case 10:
			x = 'A';
			break;
		case 8:
			x = 'B';
			break;
		case 7:
			x = 'C';
			break;
		case 6:
			x = 'D';
			break;
		default:
			x = 'F';
			break;
		}
		System.out.println(x);
		sc.close();
	}

}
