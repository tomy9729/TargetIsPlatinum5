package week3;

import java.util.Scanner;

public class BJ_1037 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int[] ary = new int[x];
		int ans;
		if(x==1) {
			ans = sc.nextInt();
			ans = ans*ans;
		}
//		else if(x==2) {
//			int a = sc.nextInt();
//			int b = sc.nextInt();
//			ans = a*b;
//		}
		else {
			for(int i=0; i<x; i++) {
				ary[i] = sc.nextInt(); 
			}
			for(int l=0; l<ary.length; l++) {
				for(int i=0; i<ary.length-1; i++) {
					if(ary[i]>ary[i+1]) {
						int temp = ary[i];
						ary[i] = ary[i+1];
						ary[i+1] = temp;
					}
				}
			}
			ans = ary[0]*ary[ary.length-1];
		}
		System.out.println(ans);
	}

}
