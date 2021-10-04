package week6.day0818;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_4012 {//N개의 재료 중 N/2개를 고르는 조합문제 A가 고르면 B는 나머지를 고른다.

	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[][] tasteMap;
	static boolean[] isSelected;
	static int[] Ataste,Btaste;
	static int Min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input_SWEA4012.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		int t= Integer.parseInt(br.readLine());
		for(int tc=1; tc<=t; tc++) {
			N= Integer.parseInt(br.readLine());
			tasteMap = new int[N][N];
			isSelected = new boolean[N];
			Ataste = new int[N/2];
			Btaste = new int[N/2];
			Min = Integer.MAX_VALUE;

			for(int i=0; i<N; i++) {
				st= new StringTokenizer(br.readLine()," ");
				for(int j=0; j<N; j++) {
					tasteMap[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			combination(0,0);
			sb.append("#"+tc+" "+Min+"\n");
		}
		System.out.println(sb.toString());
	}
	private static void combination(int cnt,int idx) {
		
		if(cnt == N/2) {
			play(Ataste);
			return;
		}
		for(int i=idx; i<N; i++) {
			
			Ataste[cnt] = i;
			combination(cnt+1,i+1);
			
		}
	}
	
	private static void play(int[] tasteA) {
		
		
		for(int i=0,b=0; i<N; i++) {
			boolean flag = true;
			for(int j=0; j<N/2; j++) {
				if(Ataste[j]==i)
					flag = false;
			}
			if(flag) {
				Btaste[b++] = i;
			}
		}
		int Asum =0;
		int Bsum =0;
		for(int i=0; i<N/2; i++) {
			for(int j=0; j<N/2; j++) {
				if(i==j) continue;
				Asum += tasteMap[Ataste[i]][Ataste[j]];
				Bsum += tasteMap[Btaste[i]][Btaste[j]];
			}
//			if(Min<Math.abs(Asum-Bsum)) {
//				return;
//			}//여기서는 두 값을 빼기 때문에 다음에 들어올 값이 어떻게 바뀌는지에 따라 Min보다 작아질 수 있다..
		}
		Min = Math.min(Min, Math.abs(Bsum-Asum));
	}

}
