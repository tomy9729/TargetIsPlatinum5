package week12.day0930;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1769 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int result;
	static String answer;
	
	public static void main(String[] args) throws IOException {
		String str = br.readLine();
		play(str, 0);
		System.out.printf("%d%n%s",result,answer);
	}

	private static void play(String str, int cnt) {
		if(str.length() == 1) {
			int res = Integer.parseInt(str);

			answer = res%3==0? "YES" : "NO";
			
			result=cnt;
			return;
		}
		
		int semi = 0;
		for(int i=0; i<str.length(); i++) {
			semi += str.charAt(i) - '0';
		}
		play(semi+"",cnt+1);
		
		
	}
}
