package week6.day0819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1247 {

	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;//고객 수
	static int[][] home;//회사랑 집 좌표
	static int[][] consumer;//고객 좌표
	static boolean[] isSelected;
	static int[] Num;
	static int Min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		int t= Integer.parseInt(br.readLine());
		for(int tc=1; tc<=t; tc++) {
			N = Integer.parseInt(br.readLine());
			home = new int[2][2];//회사, 집 (x,y)
			isSelected = new boolean[N];
			Num = new int[N];
			consumer = new int[N][2];//고객 (x,y)
			Min = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0; i<2; i++) {
				home[i][0] = Integer.parseInt(st.nextToken());
				home[i][1] = Integer.parseInt(st.nextToken());
			}
			for(int i=0; i<N; i++) {
				consumer[i][0] = Integer.parseInt(st.nextToken());
				consumer[i][1] = Integer.parseInt(st.nextToken());
			}
			
			permutation(0);
			
			sb.append("#"+tc+" "+Min+"\n");
		}
		System.out.println(sb.toString());
	}
	private static void permutation(int cnt) {
		if(cnt==N) {
			play(Num);
			return;
		}
		for(int i=0; i<N; i++) {
			if(isSelected[i]) continue;
			Num[cnt] = i;
			isSelected[i] = true;
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}
	private static void play(int[] arr) {
		int sum=0;
		sum = Math.abs(home[0][0]-consumer[arr[0]][0]) + Math.abs(home[0][1]-consumer[arr[0]][1]);
		for(int i=1; i<N; i++) {
			sum += Math.abs(consumer[arr[i-1]][0] - consumer[arr[i]][0]) + Math.abs(consumer[arr[i-1]][1]-consumer[arr[i]][1]);
		}
		sum+=Math.abs(home[1][0]-consumer[arr[N-1]][0])+Math.abs(home[1][1] - consumer[arr[N-1]][1]);
		Min = Math.min(Min, sum);
		
	}

}
