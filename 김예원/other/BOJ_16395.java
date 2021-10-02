package algol;

import java.util.Scanner;

public class Pascal_16395 {
	/*
	 	파스칼의 삼각형은 재귀함수 예제이다
	  	1. 첫 번째 줄에는 1
	  	2. 두 번째 줄부터 첫 수와 마지막 수는 1
	  	3. 그 아래로 n 번째 줄의 k 번째 수를 구하고자 한다면,
	  	   n-1 번째 줄의 k-1 번째 수와 n-1 번째 줄의 k 번째 수를 더해주면 된다.
	  	** f(n,k) = f(n-1,k-1) + f(n-1,k)  **
	
	*/

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int row = sc.nextInt();
		int seq = sc.nextInt();
		
		int answer = Pascal(row,seq);
		System.out.println(answer);	
	}
	
	public static int Pascal(int n, int k) {
		if(n==1||k==n||k==1) {
			return 1;
		}
			return Pascal(n-1,k-1) + Pascal(n-1,k);
	}

}
