package week8.day0831;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2562 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] ary;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		ary = new int[9];
		for(int i=0; i<9; i++) {
			ary[i] = Integer.parseInt(br.readLine());
		}
		
		int max = Integer.MIN_VALUE;
		int maxI = 0;
		for(int i=0; i<9; i++) {
			if(max<ary[i]) {
				max = ary[i];
				maxI = i+1;
			}
		}
		System.out.println(max);
		System.out.println(maxI);
	}

}
