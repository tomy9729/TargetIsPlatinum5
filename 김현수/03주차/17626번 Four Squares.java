//17626번 Four Squares.java
package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Four_Squares_17626 {
	private static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		System.out.println(sol(N));
		
	}
	public static int sol(int n) {
		if(Math.pow((int)Math.sqrt(n), 2)==n)return 1;
		
		for(int i=1;i<(int)Math.sqrt(n)+1;i++) {
			if(Math.pow((int)Math.sqrt(n-Math.pow(i, 2)), 2)==n-Math.pow(i, 2))return 2;
		}
		
		for(int i=1;i<(int)Math.sqrt(n)+1;i++) {
			for(int j=1;j<(int)Math.sqrt(Math.pow(i, 2))+1;j++) {
				if(Math.pow((int)Math.sqrt(n-Math.pow(i, 2)-Math.pow(j, 2)), 2)==n-Math.pow(i, 2)-Math.pow(j, 2))return 3;
			}
		}
		return 4;
	}
}
