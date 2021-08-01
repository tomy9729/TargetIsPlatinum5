package week4.day0801;

import java.util.Scanner;

public class BJ_1837 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String x = sc.next();
		int y = sc.nextInt();
		boolean flag = true;
		int ex = 0;
		if(x.charAt(0)%2==0) {
			flag=false;
			ex = 2;
		}
		else {
			
			for(int i=2; i<y; i++) {
				int ret = 0;
				for(int j=0; j<x.length(); j++) {
					ret = (ret * 10 + (x.charAt(j) - '0')) % i;
//					System.out.println(ret);
				}
//				System.out.println(ret);
				if(ret==0) {
					flag = false;
					ex=i;
					break;
				}
			}
			
//			System.out.println(ret);
		}
		if(flag) {
			System.out.println("GOOD");
		}else {
			System.out.println("BAD "+ex);
		}
		
		sc.close();
		
		
	}

}
