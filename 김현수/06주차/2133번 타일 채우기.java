//2133번 타일 채우기.java
package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 타일_채우기_2133 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[31];
		
		dp[0]=1;
		dp[2]=3;
		dp[4]=11;
		for(int n=6;n<=30;n+=2) {
			dp[n] += dp[n-2]*3;
			for(int j=n-4;j>=0;j-=2) {
				dp[n]+=dp[j]*2;
			}
			
		}
		System.out.println(dp[N]);
	}
}
