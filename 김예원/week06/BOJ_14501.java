package week06.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14501 {

	static int N, max=-1;
	static int[][] schedule;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		schedule = new int[N+1][2];
		arr = new int[N+1];
		//Arrays.fill(arr, -1);
		for(int i=1;i<=N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			schedule[i][0] = Integer.parseInt(st.nextToken());
			schedule[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=N;i>0;i--) {
			dp(i);
			if(max<arr[i])
				max = arr[i];
		}
		
		System.out.println(max);

	}
	private static void dp(int n) {
		

		if(n+schedule[n][0]-1>N) {
			// 상담 날짜 넘어가는 경우
			return;
		}else {
			
			// 자신날짜의 비용을 먼저 넣어주기
			arr[n]=schedule[n][1];
			
			
			int nextIndex = n+schedule[n][0];

			
			// 다음 인덱스를 넘어가 더 효율적인 방법을 찾으면 그 값을 더해준다(예>백준 예제 4번)
			if(nextIndex<=N) {
				int next = 0;
				next = arr[nextIndex];
				for(int i=nextIndex+1;i<=N;i++) {
					//최댓값 
					if(arr[nextIndex]<arr[i]) {
						next = arr[i];
					}
				}
				arr[n] += next;
			}
		}
		return;
		
 	}

}
