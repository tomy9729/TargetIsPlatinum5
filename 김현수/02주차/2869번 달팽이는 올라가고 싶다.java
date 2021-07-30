//2869번 달팽이는 올라가고 싶다.java
package week2;

import java.util.Scanner;

public class 달팽이는_올라가고_싶다_2869 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int v = sc.nextInt();
		
		int day=(v-a)/(a-b)+1;
		if ((v-a) % (a-b)!=0)
		{
			day++;
		}
		
		System.out.println(day);
	}
}
