package binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2512 {

	static int N,M;
	static int arr[]; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int max = -2;
		for(int i=0;i<N;i++) {
			arr[i]= Integer.parseInt(st.nextToken());
			if(arr[i]>max) max = arr[i];
		}
		
		
		M = Integer.parseInt(br.readLine());
		
		/*이분탐색 시작*/
		int start = 0;
		int end = max;
		while(start <= end) {
			int mid = (start + end)/2;
			int sum = cal(mid);
			
			if(sum==M) {
				System.out.println(mid);
				return;
			}else {
				if(sum<M) {
					start = mid+1;
				}else {
					end = mid-1;
				}
			}
		}
		
		System.out.println(end);

	}
	/*mid값 찾아주는 메서드*/
	private static int cal(int mid) {
		
		int sum = 0;
		for(int a : arr) {
			if(a < mid) sum+= a;
			else sum+= mid;
		}
		
		return sum;
	}

}
