package week3.day0726;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_2738 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int[][] ans = new int[x][y];
		
		for(int i=0; i<x; i++) {
			for(int j=0; j<y; j++) {
				ans[i][j] = sc.nextInt();
			}
		}
		for(int i=0; i<x; i++) {
			for(int j=0; j<y; j++) {
				ans[i][j] += sc.nextInt();
			}
		}
		for(int i=0; i<x; i++) {
			for(int j=0; j<y; j++) {
				
				System.out.printf("%d ",ans[i][j]);
			}
			System.out.println();
		}
	}

}
