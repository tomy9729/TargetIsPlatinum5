package week06;

import java.util.Scanner;

public class BOJ_2133 {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans = 0;
		
		// N이 4보다 큰 경우
		// 4로 나누었을 때 나오는 몫 만큼까지 가능
		// ex> 12 / 4 = 3 
		// 두 쌍 블록 3개까지 가능
		
		// 우선 가장 기본적으로 2씩 나눴을 때 나올 수 있는 경우의 수
		ans += N/2 * 3;
		// 1. 4로 나누었을 때 몫 구하기 
		int block = N/4;
		if(block>=1) {
			
		}
		
		
		
		// block은 N=2를 의미
		// N개 중에 block을 둘 씩 묶을 수 있는 경우의 수
		
		
		
		
		System.out.println(ans);
	}
}
