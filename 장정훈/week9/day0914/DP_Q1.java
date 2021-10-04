package week10.day0914;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DP_Q1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] layer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		layer = new int[n+1];
		layer[0] = 1;
		layer[1] = 2;
		for(int i=2; i<=n; i++) {
			layer[i] = layer[i-1] + layer[i-2];
		}
		System.out.println(layer[n]);
	}

}
