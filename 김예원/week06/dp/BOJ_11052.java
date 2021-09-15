package week06.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11052 {

	static int N;
	static int[][] arr;
	static int[] dpArr;
	static int max, subMax;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N+1][2];
		dpArr = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=1;i<=N;i++) {
			arr[i][0]=i;
			arr[i][1]=Integer.parseInt(st.nextToken());
		}
		// 중간값 max
		subMax = 0;
		max = arr[N][1];
		for(int i=1;i<N;i++) {
			dp(i);
		}
		
	}
	private static void dp(int cnt) {
		// 1부터 해서 최댓값 구하기
		
		int num = 0;
		int sum = 0;
		out : for(int i=cnt;i>=1;i--) {
			num += i;
			sum += arr[i][1];
			if(num>N) {
				num -= i;
				sum -= arr[i][1];
				continue;
			}
			else if(num!=N&&i==1) {
				while(true) {
					num += i;
					sum+=arr[i][1];
					if(num==N)
						break out;
				}
			}
		}
		if(max<sum) {
			max = sum;
			dpArr[cnt] = sum;
		}
		
	}
	private static void subSet(int n, int sum, int[]subArr) {
		if(sum==n) {
			
			
			
		}
		
		
		
		
	}

}
