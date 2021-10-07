//2003번 수들의 합2.java
package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수들의_합2_2003 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] num = new int[N+2];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=1;i<=N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 0;
		int now = 0;
		int i=1;
		int j=1;
		while(i<=j && j<=N+1) {		
			if(now < M) {
				now += num[j++];
			}
			else {
				now -= num[i++];
			}
			if(now == M) {
				answer++;
			}
		}
		
		System.out.println(answer);
	}
}
