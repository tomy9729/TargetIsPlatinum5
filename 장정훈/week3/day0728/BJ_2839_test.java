package week3.day0728;

import java.util.Scanner;

public class BJ_2839_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//int x = sc.nextInt();
		for(int i=3; i<5001; i++) {
			if(A(i)!=B(i)) {
				System.out.println(i);
				
				System.out.println("A = "+A(i));
				System.out.println("B = "+B(i));
			}
		}
	}
	public static int A(int x) {
		
		int t = x/3; // 들고 다닐 수 있는 최대 개수 -> 안 나누어 떨어질 때 빼고 ex)4
		int[][] ary = new int[t][2];//[i][0] 5개짜리 [i][1] 3개짜리
		int p = 0; //5개 개수
		//최소개수는 5개로만 이루어질 수 있을 때. ex)15 -> 5봉지 3개 / 3봉지 0개
		
		if(x>=3 && x<5001){
			if(x%5==0) {
				return x/5;
				//System.out.println(x/5);//5개로 나누어 떨어지면,
			}else {//
				for(int i=0; i<t; i++) {
					p = (x-(5*i))/5;
					if((x-(p*5))%3==0) {
						ary[i][0] = p; 
						ary[i][1] = (x-(p*5))/3;
						
					}
				}
				int min = Integer.MAX_VALUE;
				for(int i=0; i<t; i++) {
					
					if((min>ary[i][0] + ary[i][1])&&(ary[i][0] + ary[i][1] != 0)) {
						min = ary[i][0] + ary[i][1];
					}
				}
				if(min!=Integer.MAX_VALUE) {
					return min;
				}else {
					return -1;
				}
			}
		}
		
		return -1;
	}
	public static int B(int n) {
	    
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
	      return sum;
	}
}
