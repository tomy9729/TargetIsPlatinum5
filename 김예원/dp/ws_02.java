package dp;

import java.util.Scanner;

public class ws_02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] paint = new int[N+1];
		paint[0] = 1;
		paint[1] = 2;
		for(int i=2;i<=N;i++) {
			paint[i] = paint[i-1]*2 + paint[i-2];
		}
		
		System.out.println(paint[N]);
	}
}
