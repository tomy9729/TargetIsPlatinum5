package week12.day0928;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_8458 {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
	static int N;
	static int A;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input_SWEA8458.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int result = 0;
			N = Integer.parseInt(br.readLine());
			A = 0;
			boolean check = true;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				//여기까지는 2차원.
				x = Math.abs(x);
				y = Math.abs(y);
				//이렇게 하면 1사분면만 활용.
				int a = x+y;
				//이렇게 하면 0<= a 의 직선에서의 위치
				
				if(a%2 != A%2) {
					if(i!=0) {
						check = false;
					}
				}
				A = Math.max(a, A);
				//이렇게 하면 최대값만 뽑아서 비교하게 됨
			}
			if(!check) {
				result = -1;
			}else {
				int semi = 0;
				int i=0;
				while(true) {
					semi += i;
					if(A<= semi && A%2 == semi%2) {
						//A보다 같거나 커질 때
						//A가 짝수(홀수)면 semi도 짝수(홀수)일 때
						break;
					}
					i++;
				}
				result=i;
				
				
			}
			sb.append("#"+t+" "+result+"\n");
		}
		System.out.println(sb.toString());
	}
	
	
}
