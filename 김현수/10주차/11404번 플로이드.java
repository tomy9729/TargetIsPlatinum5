//11404번 플로이드.java
package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 플로이드_11404 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] city = new int[n+1][n+1];
		
		for(int i=1;i<=n;i++)
			for(int j=1;j<=n;j++)
				city[i][j]=10000001;
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			if(city[from][to]==0 || city[from][to]>cost) {
				city[from][to] = cost;
			}
		}
				
		for(int k=1;k<=n;k++) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(city[i][j] > city[i][k]+city[k][j] && i!=j) {
						city[i][j] = city[i][k]+city[k][j];
					}
				}
			}
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(city[i][j]==10000001) sb.append(0+" ");
				else sb.append(city[i][j]+" ");
			}sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
