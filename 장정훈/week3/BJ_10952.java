package week3;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_10952 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] sum = new int[1];
		int i=0;
		while(true) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			if(x==0 && y==0) {
				break;
			}
			sum[i]=x+y;
			
			i++;
			sum = Arrays.copyOf(sum, i+1);
		}
		i = 0;
		while(true) {
			if(sum[i]==0) {
				break;
			}
			System.out.println(sum[i]);
			i++;
		}
	}

}
