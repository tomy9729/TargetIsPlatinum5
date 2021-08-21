//1436번 영화감독 숌.java
package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 영화감독_숌_1436 {
	private static int N;
	private static int count;
	private static int num;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		count = 0;
		num=666;
		
		while(count<N) {
			String numString = Integer.toString(num++);
			if(endNum(numString))count++;
		}
		System.out.println(num-1);
	}
	
	public static boolean endNum(String num) {
		if(num.contains("666"))return true;
		else return false;
	}
}
