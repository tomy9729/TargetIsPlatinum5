//2748번 피보나치 수 2.java
package week2;

import java.util.Scanner;

public class 피보나치_수2_2748 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long[] fibo = new long[91]; //주어진 범위 안의 모든 피보나치를 구함
		fibo[0]=0;
		fibo[1]=1;
		for(int i=2;i<fibo.length;i++) {
			fibo[i] = fibo[i-1]+fibo[i-2];
		}
		
		int n = sc.nextInt();
		System.out.println(fibo[n]);
	}
}
