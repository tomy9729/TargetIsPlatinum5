//5904번 Moo 게임.java
package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Moo_게임_5904 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int N;
    static int now;
    static int preNow;
    static int mid;
    public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		preNow=0;
		now=3;
		mid=3;
		
		while(N > now) {
			preNow = now;
			now = now*2+(mid+1);
			mid++;
		}
		
		while(true) {
			if(preNow < N && N <= preNow+mid) {
				N -= preNow;
				break;
			}
			if(N <= preNow) {				
				now = preNow;
				mid--;
				preNow = (now-mid)/2;
			}
			else {
				now = preNow;
				N -= (preNow+mid);
				mid--;
				preNow = (now-mid)/2;
			}
			
		}
		
		if(N==1)System.out.println('m');
		else System.out.println('o');
	}
}
