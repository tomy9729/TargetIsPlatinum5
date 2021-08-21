//6603번 로또.java
package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 로또_6603 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int N;
    static int[] lotto;
    static int[] select;
    public static void main(String[] args) throws NumberFormatException, IOException {
		while(true) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			if(N==0)break;
			
			lotto = new int[N];
			select = new int[6];
			for(int i=0;i<N;i++) {
				lotto[i] = Integer.parseInt(st.nextToken());
			}
			com(0,0);
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}
    
    public static void com(int cnt, int start) {
    	if(cnt==6) {
    		for(int i=0;i<6;i++) {
    			sb.append(lotto[select[i]]+" ");
    		}sb.append("\n");
    		return;
    	}
    	for(int i=start;i<N;i++) {
    		select[cnt]=i;
    		com(cnt+1,i+1);
    	}
    }
}
