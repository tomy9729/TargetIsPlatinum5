//1977번 완전제곱수.java
package week2;

import java.util.Scanner;

public class 완전제곱수_1977 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		int result = 0;
		int min = 0;
		for(int i=1;i<=100;i++) {
			int temp = i*i;
			if(M<=temp && temp<=N ) {
				if(min==0)min=temp;
				result+=temp;
			}
		}
		if(min==0)System.out.println(-1);
		else {
			System.out.println(result);
			System.out.println(min);
		}
	}
}
