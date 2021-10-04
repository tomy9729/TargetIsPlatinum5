package week8.day0830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_12927 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static char[] info;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		String str = br.readLine();
		int len = str.length();
		info = new char[len+1];
		for(int i=1; i<=len; i++) {
			info[i] = str.charAt(i-1);
		}
		if(!str.contains("Y")) {
			System.out.println("0");
		}else if(!str.contains("N")) {
			System.out.println("1");
		}else {
			for(int i=1; i<=len; i++) {
				if(info[i]=='N') {
					continue;
				}
				for(int j=i; j<=len; j+=i) {
					if(info[j] == 'N') {
						info[j] = 'Y';
					}else {
						info[j] = 'N';
					}
				}
				cnt++;
			}
			System.out.println(cnt);//-1이 나올 일이 없다.
		}

	}

}
