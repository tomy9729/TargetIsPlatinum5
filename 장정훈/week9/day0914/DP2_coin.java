package week10.day0914;

import java.util.Scanner;

public class DP2_coin {

	public static void main(String[] args) {
		//거스름돈 구하기
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		int[] D = new int[money+1];
		
		D[0] = 0;
		for(int i=1; i<=money; i++) {
			int min = Integer.MAX_VALUE;
			
			if(i>=1 && D[i-1]+1<min) {
				min = D[i-1]+1;
			}
			if(i>=4 && D[i-4]+1<min) {
				min = D[i-4]+1;
			}
			if(i>=6 && D[i-6]+1<min) {
				min = D[i-6]+1;
			}
			
			D[i] = min;
			
		}
		System.out.println(D[money]);
	}

}
