//2193번 이친수.java
package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이친수_2193 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		long all[] = new long[91];
		long endone[] = new long[91];
		all[1]=1;
		endone[1]=1;
		
		for(int i=2;i<=90;i++) {
			all[i] = all[i-1]*2-endone[i-1];
			endone[i] = all[i-1]-endone[i-1];
		}
		System.out.println(all[N]);
	}
}
