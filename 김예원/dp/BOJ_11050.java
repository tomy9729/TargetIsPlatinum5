package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11050 {

	static int N, K;
	static long[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken())+1;
		K = Integer.parseInt(st.nextToken())+1;
		
		arr= new long[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<=i;j++) {
				if(j==0 || i==j ) arr[i][j] =1;
				else arr[i][j] = (arr[i-1][j-1] + arr[i-1][j])%1000000007;
			}
			
		}
		
			System.out.println(arr[N-1][K-1]);
		
		
	}

	
	
}
