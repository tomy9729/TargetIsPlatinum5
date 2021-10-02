package week07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2579 {

	static int N;
	static int[] dp;
	static int[] arr;
 	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		dp = new int[N+1];
		arr= new int[N+1];
		
		for(int i=1;i<=N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		//rec(N,1,0);
		System.out.println(rec(N,1,0));

	}
	private static int rec(int index, int count, int sum) {
		
		if(index ==0 || index == -1) {
			return sum;
		}

		sum += arr[index];
		
		if(count == 2)
			return rec(index-2,1,sum);
		else
			return Math.max(rec(index-2,1,sum), rec(index-1,2,sum));		
		
	}

}
