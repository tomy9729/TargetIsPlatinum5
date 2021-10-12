package week13.day1007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1806 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, S;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		arr = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int min=Integer.MAX_VALUE;
		int start=0;
		int end=0;
		int sum=0;
//		while(end<N) {
//			
////			if(sum<M) {
////				sum += arr[end];
////				end++;
////			}else {
////				sum -= arr[start];
////				start++;
////				
////			}
//			if(N<=end) {
//				break;
//			}
//			if(sum>=M) {
//				sum -= arr[start++];				
//			}
//			else{
//				sum += arr[end++];
//				
//			}
//			if(sum==M) {
//				cnt++;
//			}
//		}
		while(true) {
//			if(end==N)break;
			if(sum>=S) {
				sum -= arr[start++];
				min = Math.min(min, (end+1)-start);
				
			}else if(end==N) break;
			else sum += arr[end++];
		}
		if(min == Integer.MAX_VALUE) {
			min =0;
		}
		
		System.out.println(min);
	}
}
