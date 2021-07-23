package week3;

import java.util.Scanner;

public class BJ_2884 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x=sc.nextInt();
		int y = sc.nextInt();
		if((y-45)>=0) {
			System.out.printf("%d %d",x,(y-45));
		}else if((y-45)<0) {
			if((x-1)>=0) {
				System.out.printf("%d %d",(x-1),(y+15));
			}else if((x-1)<0) {
				System.out.printf("%d %d",(24+(x-1)),(y+15));
			}
		}
	}

}
