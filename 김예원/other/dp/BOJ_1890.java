package week06.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1890 {

	static int N;
	static int[][] arr;
	static long[][] mez; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		mez = new long[N][N];
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp(0,0);
		for(long[] a : mez) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println(mez[0][0]);
		
	}
	private static void dp(int r, int c) {
		int d = arr[r][c];
		boolean right=true,bottom=true;
		// 기저조건
		if(r==N-1 && c==N-1) {
			return;			
		}
		
		
		// 오른쪽 범위 체크
		if(!isIn(r,c+d)) {
			//안감
			right=false;
		}else {

			//오른쪽
			if(mez[r][c+d]==0) {
				mez[r][c+d] = 1;
				dp(r,c+d);

			}
		}
		
		
				
				
		// 아래 범위 체크
		if(!isIn(r+d,c)) {
			bottom = false;
		}else {
			//아래
			if(mez[r+d][c]==0) {
				mez[r+d][c] = 1;
				dp(r+d,c);
			}
		}
		
		if(right&&bottom) {
			mez[r][c] = mez[r+d][c] + mez[r][c+d];
		}else if(right==false&&bottom) {
			mez[r][c] = mez[r+d][c];
		}else if(bottom == false&&right) {
			mez[r][c] =mez[r][c+d];
		}else {
			mez[r][c] = 0;
		}
		
		return;
		
	}
	private static boolean isIn(int r, int c) {
		return r>=0 && r<N && c >=0 && c<N;
	}

}
