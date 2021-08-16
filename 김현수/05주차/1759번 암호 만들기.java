//1759번 암호 만들기.java
package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 암호_만들기_1759 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int L;
    static int C;
    static String[] c;
    static String password;
    public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		c = new String[C];
		
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<C;i++)c[i]=st.nextToken();
		Arrays.sort(c);
		
		password = "";
		backTracking(0,0);
		
	}
    public static void backTracking(int count, int start) {
    	if(count==L) {
    		String vowel = "aeiou";
    		int vowelCount = 0;
    		int consonantCount = 0;
    		for(int i=0;i<L;i++) {
    			if(vowel.contains(password.substring(i, i+1))) vowelCount++;
    			else consonantCount++;
    		}
    		if(vowelCount>=1 && consonantCount>=2)System.out.println(password);
    		return ;
    	}
    	for(int i=start;i<C;i++) {
    		password += c[i];
    		backTracking(count+1,i+1);
    		password = password.substring(0, password.length()-1);
    	}
    }
}
