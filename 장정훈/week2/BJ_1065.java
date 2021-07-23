package week2;

import java.util.Scanner;

public class BJ_1065 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int res = 0;
		if(x==1000) {
			x=999;
			
		}
		if(x < 100) {
			res = x;
		}else {
			res += 99;
			for(int i=100; i<=x; i++) {
				int a = i/100;
				int b = (i/10)%10;
				int c = i%10;
				if((a-b)==(b-c)) {
					res +=1;
				}
			}
		}
		System.out.println(res);
		sc.close();
	}

}
