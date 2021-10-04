package week7.day0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_8320 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		for(int i=1; i<=N; i++) {
			for(int j=i; i*j<=N; j++) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
