package week3;

import java.util.Scanner;

public class BJ_10871 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int[] ary = new int[x];
		for(int i =0; i<x; i++) {
			ary[i] = sc.nextInt();
		}
		for(int a : ary) {
			if(a!=0 && a<y) {
				System.out.printf("%d ",a);
			}
		}
		sc.close();
	}

}
