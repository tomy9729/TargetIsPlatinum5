package week3.day0728;

import java.util.Scanner;

public class BJ_2839_1 {

	public static void main(String[] args) {
	      Scanner sc=new Scanner(System.in);
	      int n=sc.nextInt();
	      int sum=0;
	      
	      while(true) {
	         //5로 나누어 떨어질때
	         if(n%5==0) {
	            sum+=n/5;
	            break;
	         }
	         if(n<0) {
	            sum=-1;
	            break;
	         }
	         n=n-3;
	         sum++;
	   }
	      System.out.printf("%d",sum);
	}

}
