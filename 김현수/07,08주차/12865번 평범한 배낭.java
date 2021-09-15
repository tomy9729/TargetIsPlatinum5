//12865번 평범한 배낭.java
package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평범한_배낭_12865 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int wv[][] = new int[N+1][2];
		int start = 10000;
		int[][] bag = new int[N+1][K+1];
		
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine()," ");
			wv[i][0] = Integer.parseInt(st.nextToken());
			wv[i][1] = Integer.parseInt(st.nextToken());
			start = Math.min(start, wv[i][0]);
			for(int j=start;j<K+1;j++) {
				if(wv[i][0]<=j) {
					bag[i][j]=Math.max(wv[i][1]+bag[i-1][j-wv[i][0]],bag[i-1][j]);
				}
				else {
					bag[i][j]=bag[i-1][j];
				}
			}
		}
		System.out.println(bag[N][K]);
	}
}
