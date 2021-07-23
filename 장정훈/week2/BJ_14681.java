package week2;

import java.util.Scanner;

public class BJ_14681 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int res = 0;
		if(x>0 && y>0) {
			res =1;
		}else if(x<0 && y>0) {
			res = 2;
		}else if(x<0 && y<0) {
			res = 3;
		}else if(x>0 && y<0) {
			res = 4;
		}
		System.out.println(res);
		sc.close();
	}

}
