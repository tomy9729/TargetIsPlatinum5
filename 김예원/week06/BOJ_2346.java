package week06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Point{
	int index, move;

	public Point(int index, int move) {
		super();
		this.index = index;
		this.move = move;
	}
	
}

public class BOJ_2346 {

	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		
		Deque<int[]> q = new ArrayDeque<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			q.add(new int[] {i, Integer.parseInt(st.nextToken())});
		}
	
		StringBuilder sb = new StringBuilder();
		while(!q.isEmpty()) {
			int[] d = q.peek();
			sb.append(d[0]).append(" ");
			q.poll();
			if(q.isEmpty()) break;
			if(d[1]>0) {
				for(int t=0;t<d[1]-1;t++) {
					q.addLast(q.pollFirst());
				}
				
			}else {
				for(int t=0;t<Math.abs(d[1]);t++) {
					q.addFirst(q.pollLast());
				}
			}
		}
		
		System.out.println(sb.toString());
		
	}

}
