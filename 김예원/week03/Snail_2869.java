package algol;

import java.util.Scanner;

public class Snail_2869 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// 올라가는 거리
		int A = sc.nextInt();
		// 내려가는 거리
		int B = sc.nextInt();
		// 총 올라가야 하는 거리
		int V = sc.nextInt();

		int snail = 0;

		int days = 0;
		while(snail<V-A) {
			days++;
			snail += (A-B);
		}
		out : while(snail<V) {
			days++;
			for(int a = 0; a<A;a++) {
				snail++;
				if(snail == V)
					break out;
			}
			snail -= B;
		}
		
		
		
		System.out.println(days);
		
	}

}
