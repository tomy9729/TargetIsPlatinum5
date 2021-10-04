package week7.day0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_17413 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static Stack<Character> stack;
	static char[] strAry;
	
	public static void main(String[] args) throws IOException {
		String str = br.readLine();
		strAry = str.toCharArray();
		stack = new Stack<>();
		int N = str.length();
		for(int n=0; n<N; n++) {
			char extra = strAry[n];
			if(extra=='<') {
				if(!stack.isEmpty()) {
					while(!stack.isEmpty()) {
						sb.append(stack.pop());
					}
				}
				sb.append("<");
				while (extra!='>') {
					extra = strAry[++n];
					sb.append(extra);
				}
			}else if(extra == ' ') {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(" ");
			}
			else{
				stack.push(extra);
			}
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		
		System.out.println(sb.toString());
	}

}
