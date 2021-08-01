package week3.day0726;

import java.util.Scanner;

public class BJ_2775 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int[] ans = new int[x];
		for(int i=0; i<x; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(b==1) {
				ans[i]=1;
			}
			else if(a==1) {
				for(int l=1; l<b+1; l++) {
					ans[i] = ans[i]+l;
				}
			
			}else {
				int[][] ary = new int[a+1][b];
				for(int l=0; l<b; l++) {
					ary[0][l] = l+1;
				}
				for(int l=1; l<a+1; l++) {
					ary[l][0]=1;
					for(int j=1; j<b; j++) {
						ary[l][j] = ary[l][j-1] + ary[l-1][j];
					}
				}
				ans[i] = ary[a][b-1];
			}
			
		}
		for(int i=0; i<x; i++) {
			System.out.println(ans[i]);
		}
	}

}
