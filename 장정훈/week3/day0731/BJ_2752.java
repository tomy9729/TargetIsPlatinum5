package week3.day0731;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_2752 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] ary = new int[3];
		for(int i=0; i<3; i++) {
			ary[i] = sc.nextInt();
		}
		Arrays.sort(ary);
		for(int i=0; i<3; i++) {
			System.out.printf("%d ",ary[i]);
		}
	}

}
