//2775번 부녀회장이 될테야.java
package week2;

import java.util.Scanner;

public class 부녀회장이_될테야_2775 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i=0;i<T;i++) {
			int k= sc.nextInt();
			int n = sc.nextInt();
			
			int apart[][] = new int[k+1][n+1];
			for(int a=0;a<k+1;a++) {
				for(int b=1;b<n+1;b++) {
					if(a==0) {
						apart[a][b]=b;
					}
					else {
						for(int c=0;c<=b;c++) {
							apart[a][b]+=apart[a-1][c];
						}
					}
				}
			}
			System.out.println(apart[k][n]);
		}
	}
}
