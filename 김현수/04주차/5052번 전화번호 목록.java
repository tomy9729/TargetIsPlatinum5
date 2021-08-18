//5052번 전화번호 목록.java
package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 전화번호_목록_5052 {
	private static int T;
	private static int N;
	private static String[] phoneNumber;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			N = Integer.parseInt(br.readLine());
			phoneNumber = new String[N];
			for(int i=0;i<N;i++) {
				phoneNumber[i] = br.readLine();
			}
			Arrays.sort(phoneNumber);
			
			boolean check=true;
			for(int i=0;i<N-1;i++) {
				if(phoneNumber[i].length()<=phoneNumber[i+1].length()) {
					if(phoneNumber[i].equals(phoneNumber[i+1].substring(0,phoneNumber[i].length()))){
						check=false;
						break;
					}
				}
			}
			if(check)sb.append("YES").append("\n");
			else sb.append("NO").append("\n");
		}
		System.out.println(sb.toString());
	}
}
