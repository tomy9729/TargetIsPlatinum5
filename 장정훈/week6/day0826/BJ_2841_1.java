package week7.day0826;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_2841_1 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N,P;//N은 멜로디 횟수.
	static Stack<Integer>[] stack;
	static int cnt;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		stack = new Stack[7];
		for(int i=1; i<=6; i++) {
			stack[i] = new Stack<>();
		}
		cnt = 0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int n = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			if(stack[n].isEmpty()) {
				cnt++;
				stack[n].push(p);
				continue;
			}else {
				if(stack[n].peek()<p) {
					stack[n].push(p);
					cnt++;
					continue;
				}else {
					if(stack[n].peek() == p) {
						continue;
					}else if(stack[n].peek()>p) {
						while(!stack[n].isEmpty() && stack[n].peek()>p) {
							stack[n].pop();
							cnt++;
						}
						if(stack[n].isEmpty() || stack[n].peek()<p) {
							cnt++;
							stack[n].push(p);
						}
					}
				}
			}
		}
		
		System.out.println(cnt);
	}

}
