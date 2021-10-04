package week6.day0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_5215 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N,L;//재료 개수, 제한 칼로리
	static int[][] item;
	static int maxCal;
	static int maxScore;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		int t = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=t; tc++) {
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			maxCal = 0;
			maxScore = 0;
			item = new int[N][2];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine()," ");
				item[i][0] = Integer.parseInt(st.nextToken());
				item[i][1] = Integer.parseInt(st.nextToken());
			}
			
			superSet(0,new boolean[N]);
			
			sb.append("#"+tc+" "+maxScore+"\n");
		}
		System.out.println(sb.toString());
	}
	private static void superSet(int cnt, boolean[] isSelected) {
		if(cnt==N) {
			play(isSelected);
			return;
		}
		isSelected[cnt]=true;
		superSet(cnt+1, isSelected);
		isSelected[cnt]=false;
		superSet(cnt+1, isSelected);
	}
	private static void play(boolean[] isSelected) {
		int sumS=0;
		int sumC=0;
		boolean flag = false;
		for(int i=0; i<N; i++) {
			if(!isSelected[i]) continue;
			flag = true;
			sumS += item[i][0];
			sumC += item[i][1];
			if(sumC>L) {
				return;
			}
		}
		if(flag) {
			maxScore = Math.max(maxScore, sumS);
		}
	}

}
