package week4.day0801;

import java.util.Scanner;

public class BJ_17626 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int[] ary = new int[x+1];//1부터 시작하기 위해
		ary[1] = 1;
		int min;
		
		for(int i=2; i<x+1; i++) {
			min = Integer.MAX_VALUE;//숫자마다 판별해줘야 되서 밑에서 0일 될 때를 대비해 항상 초기화
			
			for(int j=1; j*j<=i; j++) {//2,3이 1보다 크고 2보단 작을때
				//4는 1과 2 가능.
				//9는 1과 3 가능.
				//5,6,7,8이 2보다는 크고 3보다는 작은 거
				int temp = i-j*j;
				min = Math.min(min, ary[temp]);
			}
			ary[i] = min+1;
			
			
		}
		System.out.println(ary[x]);
		sc.close();
	}

}
