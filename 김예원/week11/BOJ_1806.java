package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806 {

	static int N, length=100000;
	static long S;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] =  Integer.parseInt(st.nextToken());
			if(arr[i]>=S) {
				System.out.println(1);
				return;
			}
			
		}
		
		partSum();
		
		if(length==100000) {
			System.out.println(0);	
		}else {			
			System.out.println(length);
		}

	}
	private static void partSum() {

		int  start = 0; int end = 0;
		long sum=arr[0];
		while(true) {
			if(sum>=S) {
				length = Math.min(length, (end-start+1));
				sum-= arr[start];
				start++;
			}else {
				end++;
				if(end==N)
					break;
				sum+= arr[end];

			}
		}
		
	}

}
