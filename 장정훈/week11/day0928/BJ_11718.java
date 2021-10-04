package week12.day0928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11718 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		String str;
		while((str=br.readLine())!=null && !str.isEmpty()) {
			sb.append(str+"\n");
//			System.out.println(str);
		}
		System.out.println(sb.toString());
	}
}
