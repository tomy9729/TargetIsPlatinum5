package week15.day1029;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class NHN2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M;
	static Set<String> numberSet;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			numberSet = new HashSet<>();
			st = new StringTokenizer(br.readLine()," ");
			int answer = 0;
			for(int i=0; i<N; i++) {
				numberSet.add(st.nextToken());
				if(numberSet.size() == M) {
					answer = i+1;
					break;
				}
			}
			sb.append(answer);
			if(t!=T-1) {
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());

	}
}
