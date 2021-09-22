package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920 {

	/**
	 * 이진탐색
	 */
	static int N,M;
	static long[] arrN, arrM;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arrN = new long[N];
		

		// N개의 배열 초기화
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arrN[i] = Integer.parseInt(st.nextToken());
		}

		// 정렬
		Arrays.sort(arrN);
		
		// M개의 배열 초기화
		M = Integer.parseInt(br.readLine());
		arrM = new long[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			arrM[i] = Integer.parseInt(st.nextToken());
		}
		

		
		for(int i=0;i<M;i++) {
			if(findNum(arrM[i]))
				sb.append(1).append("\n");
				//System.out.println(1);
			else
				sb.append(0).append("\n");
				//System.out.println(0);
		}
		
		System.out.println(sb.toString());
		
	}
	private static boolean findNum(long n) {
		
		
		// arrN 배열의 최댓값보다 크다면, 최솟값보다 작다면 false 
		if(n>arrN[N-1] || n < arrN[0]) return false;
		
		// 이분탐색
		int low = 0;
		int high = N-1;
		
		while(low<=high) {
			
			int mid = (low + high) / 2;
			
			if(arrN[mid]==n) {
				return true;
			}else {
				if(arrN[mid]<n) {
					low = mid+1;
				}else {
					high = mid-1;
				}
			}
			
		}
		
		
		// 찾은 값이 없음
		return false;
	}

}
