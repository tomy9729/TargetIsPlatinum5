package week10.day0916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_12865 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		int[] weight = new int[N+1];
		int[] profits = new int[N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			weight[i] = Integer.parseInt(st.nextToken());
			profits[i] = Integer.parseInt(st.nextToken());
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
