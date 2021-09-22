package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_8983 {

	static int N,M;
	static int count = 0;
	static long L;
	static long[] arr;
	static long[][] points;
	static boolean[] available;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 사대의 수, 동물의 수, 사정거리
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		available = new boolean[M];
		arr = new long[N];
		// x-points
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		points = new long[M][2];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			/*points[i][0] = Integer.parseInt(st.nextToken());
			points[i][1] = Integer.parseInt(st.nextToken());*/
			
			long x =Integer.parseInt(st.nextToken());
			long y =Integer.parseInt(st.nextToken());
			
			hunt(x,y);
			
		}
		
		
		/*long count = 0;
		for(int i=0;i<N;i++) {
			
			long x = arr[i];
			for(int j=0;j<M;j++) {
				if(available[j]==true)
					continue;
				
				
				if(Math.abs(x - points[j][0])+points[j][1]>L)
					continue;
				else {
					available[j]=true;
					count++;
				}
			}
		}*/
		
		
		System.out.println(count);
	}

	private static void hunt(long x, long y) {
		int start = 0;
		int end = arr.length-1;
		
		while(start<= end) {
			int mid = (start+end)/2;
			
			long xm = arr[mid];
			
			if(Math.abs(xm - x) + y > L) {
				if(xm > x)
					end = mid -1;					
				else if(xm < x)
					start = mid+1;
				else
					return;
			}else {
				count++;
				return;
			}
		}
		
		return;
	}
}
