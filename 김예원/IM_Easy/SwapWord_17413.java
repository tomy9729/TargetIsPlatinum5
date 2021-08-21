package algol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class SwapWord_17413 {

	public static void main(String[] args) throws
	IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] arr = br.readLine().toCharArray();
		//System.out.println(Arrays.toString(arr));
		Stack<Character> stack = new Stack<>();
		
		StringBuilder sb = new StringBuilder();
		
		int i = 0;
		outer : while(i <arr.length) {
			// 태그 만나면
			if(arr[i]=='<') {
				if(!stack.isEmpty()) {
					
					while(!stack.isEmpty())sb.append(stack.pop());
				}
				while(arr[i]!='>') sb.append(arr[i++]);
				sb.append(arr[i++]);
				continue outer;
			}
			// 공백 만나면
			if(arr[i]==' ') {
				// 출력
				while(!stack.isEmpty())sb.append(stack.pop());
				sb.append(arr[i++]);
				continue outer;
				// 스택 초기화
			}
			stack.push(arr[i++]);
		}
		if(!stack.isEmpty()) {
			while(!stack.isEmpty())sb.append(stack.pop());
		}
	
		System.out.println(sb.toString());
	}

}
