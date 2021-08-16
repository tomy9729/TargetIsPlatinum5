//2217번 로프.java
package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 로프_2217 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int N;
    static Integer[] rope;
    static int answer = 0;
    static int minRope = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		 N = Integer.parseInt(br.readLine());
		 rope = new Integer[N];
		 for(int i=0;i<N;i++) {
			 rope[i] = Integer.parseInt(br.readLine());
		 }
		 Arrays.sort(rope,Collections.reverseOrder());
		 
		 answer = rope[0];
		 for(int i=1;i<N;i++) {
			 answer = Math.max(answer, rope[i]*(i+1));
		 }
		 System.out.println(answer);
	}
}
