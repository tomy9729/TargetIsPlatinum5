package week2;

import java.util.Scanner;

public class BJ_10818 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int[] ary = new int[x];
		int max = 0;
		int min = 0;
		for(int i=0; i<x; i++) {
			ary[i] = sc.nextInt();
		}
		max = ary[0];
		min = ary[0];
		for(int i=0; i<ary.length; i++) {
			if(max < ary[i]){
				max = ary[i];
			}
			if(min > ary[i]) {
				min = ary[i];
			}
			
		}
		System.out.printf("%d %d",min, max);
		sc.close();
	}

}
