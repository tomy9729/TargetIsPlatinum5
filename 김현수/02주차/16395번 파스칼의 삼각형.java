//16395번 파스칼의 삼각형.java
package week2;

import java.util.Scanner;

public class 파스칼의_삼각형_16395 {
	public static int pascal(int n, int k) {
		if(k==1 || k == n)return 1;
		return pascal(n-1,k-1)+pascal(n-1,k);
	}
	public static void main(String[] args) {
		Scanner sc = new  Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(pascal(n,k));
	}
}	
