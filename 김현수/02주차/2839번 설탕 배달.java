//2839번 설탕 배달.java
package week2;

import java.util.Scanner;

public class 설탕_배달_2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sugar = sc.nextInt();
		int t_count=0;
		
		while(true) {
			if((sugar-3*t_count)%5==0) {
				System.out.println(t_count+(sugar-3*t_count)/5);
				break;
			}
			if(3*t_count > sugar) {
				System.out.println(-1);
				break;
			}
			t_count++;
		}
	}
}
