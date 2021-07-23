package week2;

import java.util.Scanner;

public class BJ_4344 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		double[] result = new double[x];
		
		for(int i=0; i<x; i++) {
			int n = sc.nextInt();
			double res = 0;
			int[] y = new int[n];
			for(int j=0; j<n; j++) {
				y[j] = sc.nextInt();
				res += y[j];
			}
			res = res/n;
			int z = 0;
			for(int j=0; j<n; j++) {
				if(y[j]>res) {
					z +=1;
				}
			}
//			System.out.println(z);
			result[i]= (z*1.0)/n*100;
//			System.out.printf("%.3f%%%n",((z*1.0)/n)*100);
		}
		for(int i=0; i<x; i++) {
			System.out.printf("%.3f%%%n",result[i]);
		}
		
	}

}
