package week7.day0826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_2841 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,P;//N은 멜로디 횟수.
	static Stack<int[]> stack;
	static int cnt;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		stack = new Stack<>();
		cnt = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			if(stack.isEmpty()) {
				cnt++;
				stack.push(new int[] {n,p});
				continue;
			}else {
				int arr[] = stack.peek();
				if(arr[0]==n) {
					if(arr[1] < p) {
						stack.push(new int[] {n,p});
						cnt++;
					}else {
						stack.clear();
						cnt++;
						stack.push(new int[] {n,p});
						cnt++;
					}
				}else {
					stack.clear();
					stack.push(new int[] {n,p});
					cnt++;
					continue;
				}
			}
		}
		
		System.out.println(cnt);
	}

}
