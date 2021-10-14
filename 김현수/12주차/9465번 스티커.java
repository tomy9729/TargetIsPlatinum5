//9465번 스티커.java
package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스티커_9465 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder(); 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			int n = Integer.parseInt(br.readLine());
			int[][] sticker = new int[2][n];
			for(int i=0;i<2;i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0;j<n;j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int[][] dp = new int[2][n];
			dp[0][0] = sticker[0][0];
			dp[1][0] = sticker[1][0];
			if(n>1) {
				dp[0][1] = dp[1][0]+sticker[0][1];
				dp[1][1] = dp[0][0]+sticker[1][1];
			}
			if(n>2) {
				for(int j=2;j<n;j++) {
					dp[0][j] = Math.max(dp[1][j-1], dp[1][j-2])+sticker[0][j];
					dp[1][j] = Math.max(dp[0][j-1], dp[0][j-2])+sticker[1][j];
				}
			}
			
			int answer = Math.max(dp[0][n-1], dp[1][n-1]);
			sb.append(answer+"\n");
		}
		System.out.println(sb.toString());
	}
}
