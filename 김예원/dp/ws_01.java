package dp;

import java.util.Scanner;

public class ws_01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] apart = new int[N+1];
		
		apart[0]=1;
		apart[1]=2;
		for(int i=2;i<=N;i++) {
			apart[i] = apart[i-1]+apart[i-2];
		}
		
		System.out.println(N+"층 아파트를 색칠할 수 있는 경우의 수 :  "+ apart[N]);
		

	}

}
