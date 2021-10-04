package week7.day0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_3052 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] ary;
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		ary = new int[42];
		
		for(int i=0; i<10; i++) {
			ary[Integer.parseInt(br.readLine())%42]++;
		}
		
		for(int i=0; i<42; i++) {
			if(ary[i] != 0) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
