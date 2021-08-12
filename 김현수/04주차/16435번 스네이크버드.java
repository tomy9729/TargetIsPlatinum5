//16435번 스네이크버드.java
package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 스네이크버드_16435 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int N;
    static int L;
    static int[] h;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		h = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++)h[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(h);
		for(int i=0;i<N;i++) {
			if(h[i]<=L)L++;
			else break;
		}
		System.out.println(L);
	}
}
