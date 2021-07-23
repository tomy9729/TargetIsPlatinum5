package week3;

import java.util.Scanner;

public class BJ_11022 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		
		int[][] input = new int[x][2];
 		for(int i=0; i<x; i++) {
			input[i][0] = sc.nextInt();
			input[i][1] = sc.nextInt();
			
		}
 		for(int i=0; i<input.length; i++) {
 			System.out.printf("Case #%d: %d + %d = %d%n",(i+1),input[i][0],input[i][1],(input[i][0]+input[i][1]));
 		}
	}

}
