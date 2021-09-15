package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11066 {

	static int T, N;
	static int[] arr, dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int i=0;i<T;i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			arr = new int[N];
			dp = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			
			
			
		}
		
		

	}

}
