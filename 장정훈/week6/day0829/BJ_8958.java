package week7.day0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_8958 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static char[] ary;
	static int[] scoreAry;
	static int score;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int tc = Integer.parseInt(br.readLine());
		for(int t=0; t<tc; t++) {
			score = 0;
			String str = br.readLine();
			ary = str.toCharArray();
			scoreAry = new int[ary.length];
			if(ary[0] == 'O') {
				scoreAry[0] = 1;
			}else {
				scoreAry[0] = 0;				
			}
			for(int i=1; i<scoreAry.length; i++) {
				if(ary[i]=='O') {
					scoreAry[i] = scoreAry[i-1]+1;
				}else {
					scoreAry[i] = 0;
				}
			}
			for(int i=0; i<scoreAry.length; i++) {
				score += scoreAry[i];
			}
			
			sb.append(score+"\n");
		}
		System.out.println(sb.toString());
	}

}
