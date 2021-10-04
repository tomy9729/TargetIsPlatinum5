package week7.day0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10163 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] Map;
	static int N;
	static int[] findAry;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		Map = new int[1002][1002];
		findAry = new int[N+1];
		for(int n=1; n<=N; n++) {
			st = new StringTokenizer(br.readLine()," ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			for(int ii=r; ii<r+i; ii++) {
				for(int jj=c; jj<c+j; jj++) {
					Map[ii][jj] = n;
				}
			}
		}
		
		for(int i=0; i<1002; i++) {
			for(int j=0; j<1002; j++) {
				if(Map[i][j] == 0)continue;
				findAry[Map[i][j]]++;
			}
		}
		for(int i=1; i<=N; i++) {
			sb.append(findAry[i]+"\n");
		}
		System.out.println(sb.toString());
	}

}
