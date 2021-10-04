package week7.day0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_3985 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] cake;
	static int[] person;
	static int size;
	static int Max;
	static int p;
	public static void main(String[] args) throws NumberFormatException, IOException {
		size = Integer.parseInt(br.readLine());
		cake = new int[size+1];
		p = 1;
		int n= Integer.parseInt(br.readLine());
		person = new int[n+1];
		Max = Integer.MIN_VALUE;
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int wanted = (end+1) - start;
			
			if(Max<wanted) {
				Max = wanted;
				p = i;
			}
			for(int s = start; s<=end; s++) {
				if(cake[s] == 0) {
					cake[s] = i;
					person[i]++;
				}
			}
		}
		sb.append(p+"\n");
		Max = 0;
		for(int i=1; i<=n; i++) {
			if(Max<person[i]) {
				Max = person[i];
				p = i;
			}
		}
		sb.append(p);
		System.out.println(sb.toString());
		
	}

}
