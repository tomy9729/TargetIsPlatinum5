package week3.day0729;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_1026 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int[] A = new int[x];
		int[] B = new int[x];
		
		for(int i=0; i<x; i++) {
			A[i] = sc.nextInt();
		}
		for(int i=0; i<x; i++) {
			B[i] = sc.nextInt();
		}
		int[] C = B;//B 재정렬하지 말라고 해서..
		
		Arrays.sort(A);
		Arrays.sort(C);
		int sum =0;
		for(int i=0,j=x-1; i<x; i++) {
			sum += A[i]*C[j--];
			
		}
		System.out.println(sum);

	}

}
