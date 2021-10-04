package week6.day0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15655 {

	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int N,M;
	static int[] number;
	static int[] answer;
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine()," ");
		sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		number = new int[N];
		answer = new int[M];
		st = new StringTokenizer(br.readLine()," ");//N이 3일 때 다음 줄을 읽으면 토큰이 세 개가 저장될 것이다.
		for(int i=0; i<N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(number);
		combi(0,0);
		System.out.println(sb.toString());
	}

	private static void combi(int cnt, int idx) {
		if(cnt==M) {
			for(int i=0; i<M; i++) {
				sb.append(answer[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=idx; i<N; i++) {
			answer[cnt] = number[i];
			combi(cnt+1,i+1);
			
		}
		
		
	}

}
