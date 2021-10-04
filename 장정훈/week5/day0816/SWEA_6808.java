package week6.day0816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_6808 {

	static BufferedReader br;
	static StringBuilder sb;
	static StringTokenizer st;
	static int[] gAry;
	static int[] iAry;
	static boolean[] selected;
	static int[] line;
	static int win,lose;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=t; tc++) {
			win =0;
			lose=0;
			gAry = new int[9];
			iAry = new int[9];
			line = new int[9];
			selected = new boolean[18];
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0; i<9; i++) {
				gAry[i] = Integer.parseInt(st.nextToken());
				selected[gAry[i]-1] = true;
			}
			for(int i=0,l=0; i<18; i++) {
				if(selected[i]) continue;
				iAry[l++] = i+1;
			}
			selected = new boolean[9];
			
			Arrays.sort(iAry);
			permu(0);

			sb.append("#"+tc+" "+win+" "+lose+"\n");
		}
		System.out.println(sb.toString());
		
	}

	private static void permu(int cnt) {
		if(cnt == 9) {
			play(line);
			return;
		}
		for(int i=0; i<9; i++) {
			if(selected[i]) continue;
			
			line[cnt] = iAry[i];
			selected[i] = true;
			permu(cnt+1);
			selected[i] = false;
			
		}
		
		
	}

	private static void play(int[] line2) {
		
		int w=0;
		int l=0;
		
		for(int i=0; i<9; i++) {
			if(gAry[i] > line2[i]) {
				w += gAry[i]+line2[i];
			}else {
				l += gAry[i] + line2[i];
			}
		}
		if(w>l) {
			win++;
		}else {
			lose++;
		}
		
	}

}
