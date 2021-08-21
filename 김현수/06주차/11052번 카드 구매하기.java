//11052번 카드 구매하기.java
package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class 카드_구매하기_11052 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static class card implements Comparable<card>{
    	int cnt;
    	int p;
    	double cost;
    	card(int cnt, int p, double cost){
    		this.cnt = cnt;
    		this.p = p;
    		this.cost = cost;
    	}
    	@Override
		public int compareTo(card o) {
			return -1*Double.compare(this.cost, o.cost);
		}
		@Override
		public String toString() {
			return "card [cnt=" + cnt + ", p=" + p + ", cost=" + cost + "]";
		}
		
    	
    }
    
    static int N;
    static card[] cardes;
    static int[][] dp;
    static int answer;
    public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		cardes = new card[N+1];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=1;i<=N;i++) {
			int p = Integer.parseInt(st.nextToken());
			cardes[i] = new card(i,p, (double)p/(double)i);
		}
		dp = new int[N+1][N+1];
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(i==1) {
					dp[i][j]=cardes[i].p*j;
				}
				else if(cardes[i].cnt>j) {
					dp[i][j]=dp[i-1][j];
				}
				else {
					dp[i][j]=Math.max(dp[i-1][j], cardes[i].p+dp[i][j-i]);
				}
			}
		}
		answer = dp[N][N];
		System.out.println(answer);
		
	}
}
