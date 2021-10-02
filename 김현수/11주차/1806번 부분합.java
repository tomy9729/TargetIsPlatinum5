//1806번 부분합.java
package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분합_1806 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] num = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 100000;
		boolean check = false;
		
		int start=0;
		int end=0;
		int now=num[0];
		while(start<=end) {
			if(now>=S) {
				if(answer > end-start+1) {
					answer = end-start+1;
					check = true;
				}
			}
			if(now<=S && end<N-1) {
				now += num[++end];
			}
			else {
				now -= num[start++];
			}
		}
		
		if(check) {
			System.out.println(answer);
		}
		else {
			System.out.println(0);
		}
	}
}
