package week3.day0725;

import java.util.Scanner;

public class BJ_2748 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int in = sc.nextInt();
		long x=1;
		long y=1;
		long ans=0;//피보나치는 이전 숫자와 다음 숫자의 합이니깐 int범위를 벗어나는 것 같다!
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
