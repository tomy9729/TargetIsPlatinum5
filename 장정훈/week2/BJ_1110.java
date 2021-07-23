package week2;

import java.util.Scanner;

public class BJ_1110 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		String y = Integer.toString(x);
		String[] res1 = new String[2];
		String[] res2 = new String[2];
		int z = 0;
		int i = 0;
		do {
		if(y.length() == 1) {
			res1[0] = "0";
			res1[1] = y.charAt(0)+""; 
		}else {
			res1[0] = y.charAt(0)+"";
			res1[1] = y.charAt(1)+"";
		}
		
		z = Integer.parseInt(res1[0]) + Integer.parseInt(res1[1]);
		y = res1[1] + Integer.toString(z%10) ;
		
		
//		System.out.println(Integer.parseInt(res1[0])+"+"+Integer.parseInt(res1[1])+"="+z );
//		System.out.println("new number="+y);
		
		 i++;
		}while(x != Integer.parseInt(y));
		System.out.println(i);
		sc.close();
	}

}
