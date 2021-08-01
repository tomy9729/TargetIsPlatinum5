package week3.day0726;


import java.util.Scanner;

public class BJ_16395 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int ans =0;
		int a = sc.nextInt();
		int b = sc.nextInt(); 
		ans = answer(a,b);
		System.out.println(ans);
	}
	public static int answer(int x, int y) {
		if(y==1||x==y) {
			return 1;
		}
		return answer(x-1,y-1) + answer(x-1,y);
	}

}
