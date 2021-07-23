package week2;

import java.util.Scanner;

public class BJ_1546 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		double[] ary = new double[x];
		double max = 0;
		double res = 0;
		for(int i=0; i<x; i++){
			ary[i] = sc.nextInt();
			
		}
		max = ary[0];
		for(int i=0; i<ary.length; i++) {
			if(max < ary[i]) {
				max = ary[i];
			}
		}
//		System.out.println(max);
		for(int i=0; i<ary.length; i++) {
			ary[i] = (ary[i]/max)*100;
//			System.out.println(ary[i]);
		}
		for(double i : ary) {
			res += i;
		}
		System.out.println(res/ary.length);
		
	}

}
