package week06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2841 {

	static int N, P, count = 0;
	static Stack<Integer>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		list = new Stack[N+1];
		for (int i = 1; i <=N; i++) {
			list[i] = new Stack<Integer>();
			list[i].push(0);
			//System.out.println(list[i].toString());
		}
		
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken());
			
			int flat = Integer.parseInt(st.nextToken());

			if (list[index].isEmpty()) {
				list[index].push(flat);
				count++;
				continue;
			} else {
				while (list[index].peek() > flat) {
					list[index].pop();
					count++;
				}
				if (list[index].peek() < flat) {
					list[index].push(flat);
					count++;
				} 
			}

		}

		System.out.println(count);
	}
}
