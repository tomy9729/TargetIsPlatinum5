package week6.day0819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1759 {

	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int L,C;// cCl C개 중 L개를 고르는 조합. 단, 모음이 포함된 놈들만.
	static char[] ary;
	static char[] selectAry;
	static String str = "aeiou";
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine()," ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		ary = new char[C];//C가 L보다 크거나 같음
		selectAry = new char[L];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<C; i++) {
			ary[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(ary);
		
		combi(0,0);
		
		System.out.println(sb.toString());
	}
	private static void combi(int cnt, int idx) {
		if(cnt==L) {
			play(selectAry);
			return;
		}
		for(int i=idx; i<C; i++) {
			selectAry[cnt] = ary[i];
			combi(cnt+1,i+1);
		}
	}
	private static void play(char[] arr) {
		boolean flag = false;
		int cnt=0;
		for(int i=0; i<arr.length; i++) {
			if(str.contains(arr[i]+"")) {
				flag = true;
				
			}else {
				cnt++;
			}
		}
		if(flag&&cnt>=2) {
			for(int i=0; i<arr.length; i++) {
				sb.append(arr[i]);
			}
			sb.append("\n");
		}
		
	}

}
