package week3.day0726;

import java.util.Scanner;

public class BJ_1977 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int sum = 0;
		int nx;
		int ny;
		
		if((Math.sqrt(x)-(int)Math.sqrt(x))>0) {
			nx = (int)Math.sqrt(x)+1;
		}else {
			nx = (int)Math.sqrt(x);
		}
		
		if((Math.sqrt(y)-(int)Math.sqrt(y))>0) {
			ny = (int)Math.sqrt(y)+1;
		}else {
			ny = (int)Math.sqrt(y);
		}
		for(int i=nx; i<=ny; i++) {
			if(i*i >=x && i*i<=y) {
				sum = sum + (i*i);
			}
		}
		if(sum!=0) {
		System.out.println(sum);
		System.out.println(nx*nx);
		}
		else {
			System.out.println(-1);
		}
		
	}

}
