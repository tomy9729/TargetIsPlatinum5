package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003 {

	static int N,count;
	static long M;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] =  Integer.parseInt(st.nextToken());
		}
		
		partSum();
				
		System.out.println(count);
	

	}
	private static void partSum() {
		
		/* 
		 * start = 0, end = 1 
		 * 6 1 
		 * 1 1 1 1 1 1
		 * 에서 답이 5가 나옴(첫 번째 요소를 세지 않아서 에러 발생) 
		 */
		
		// start와 end가 동일하게 첫 요소를 가리키는 상태로 시작
		int start = 0; int end = 0;
		long sum=arr[0];

		while(true) {
			if(sum>=M) {
				
				// sum이 M과 같으면  count +1
				if(sum==M) 
					count++;
				
				// sum에서 기존 arr[start]값 삭제 후 start 포인터 +1
				sum-= arr[start];
				start++;
				
			}else {
				
				// end 포인터 +1
				end++;
				
				// end 포인터가 범위 벗어나면 종료
				if(end==N)
					break;
				
				//sum에 arr[end]값 추가 
				sum+= arr[end];
				
			}
		}
		
	}

}
