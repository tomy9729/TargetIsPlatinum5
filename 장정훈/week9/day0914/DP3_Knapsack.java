package week10.day0914;

import java.util.Scanner;

public class DP3_Knapsack {
	//Knapsack알고리즘
	
	public static void main(String[] args) {
		//가방넣기
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();
		
		int[] weight = new int[N+1];
		int[] profits = new int[N+1];
		for(int i=1; i<=N; i++) {
			weight[i] = sc.nextInt();
			profits[i] = sc.nextInt();
		}
		int[][] D = new int[N+1][W+1];
		
		for(int i=1; i<=N; i++) {
			for(int w=1; w<=W; w++) {
				if(weight[i]<=w) {
					//해당 물건을 가방에 넣을 수 있다.
					//담지 않았을 때와 담을 때의 무게를 비교할 수 있다.
					D[i][w] = Math.max(D[i-1][w], profits[i] + D[i-1][w-weight[i]]);
				}else {
					//해당 물건을 가방에 넣을 수 없다.
					D[i][w] = D[i-1][w];
				}
			}
		}
		System.out.println(D[N][W]);
	}

}
