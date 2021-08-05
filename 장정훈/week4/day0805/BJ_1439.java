package week4.day0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1439 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		int z=0;
		int o=0;
		if(str.charAt(0)=='0') {
			z++;
		}else {
			o++;
		}
//		int min=Integer.MAX_VALUE;
		for(int i=1; i<str.length(); i++) {
			if(str.charAt(i) != str.charAt(i-1)) {//연속된 숫자가 있을 때만 판별 숫자가 끊기면 한번에 뒤집을 수 없음.
				if(str.charAt(i)=='0') {
					z++;
				}else {
					o++;
				}
			}
		}
//		min = Math.min(z, o);
//		System.out.println(z+"--"+o);
		System.out.println(Math.min(z, o));
		
	}

}
