//1120번 문자열.java
package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문자열_1120 {
	private static String A;
	private static String B;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line," ");
		
		String A = st.nextToken();
		String B = st.nextToken();
		int answer = 50;
		for(int i=0;i<B.length()-A.length()+1;i++){
			int temp=0;
			for(int j=i;j<A.length()+i;j++) {
				if(B.charAt(j)!=A.charAt(j-i)) {
					temp++;
				}
			}
			answer = (answer>temp)? temp:answer;
		}
		System.out.println(answer);
	}
}
