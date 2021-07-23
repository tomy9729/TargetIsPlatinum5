package week3.day0724;

import java.util.Scanner;

public class BJ_2747 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int in = sc.nextInt();
		int x=1;
		int y=1;
		int ans=0;
		if(in==0) {
			ans=0;
		}else if((in == 1)||(in==2)) {
			ans=1;
		}else {
			for(int i=0; i<in-2; i++) {
				ans = x+y;
				x = y;
				y = ans;
			}
		}
		System.out.println(ans);
		
	}

}
