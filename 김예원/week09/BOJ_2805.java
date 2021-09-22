package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2805 {

	/**
	 * 이진탐색
	 */
	
	static int N, M;
	static long min =0;
	static long max;
	static List<Long> list = new ArrayList<>();
	static long[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new long[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			// Integer.parseInt 로 long 크기의 데이터가 들어갈 수 있는 이유?
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);
		// System.out.println(arr[N-1]+","+arr[0]);
		// high값과 low값을 넣어
		//long result = sep(arr[N - 1], 0);
		/*if (result == -1) {
			// 딱 떨어지는 값이 없는 경우

			Collections.sort(list);
			System.out.println(list.get(0));

		};*/
		max = arr[N-1];
		while(min <= max) {
			long mid = calMid(max, min);
			
			long sum = 0;
			for(long a : arr) {
				if(a>mid) {
					sum+= (a-mid);
				}
			}
			
			if(sum==M) {
				System.out.println(mid);
				return;
			}else {
				if(sum>M) {
					// 기준선을 올리면 sum이 작아진다
					min = mid+1;
				}else {
					// 기준선을 내리면 sum이 커진다
					max = mid-1;
				}
				
			}

		}
		System.out.println(max);
	}

	/*private static long sep(long high, long low) {

		if(low>high)
			return -1;
		
		long mid = calMid(high, low);
		// System.out.println(mid);
		// 비교
		long sum = 0;
		long diff = 0;
		for (int i = 0; i < N; i++) {
			if (arr[i] > mid) {
				diff = arr[i] - mid;
				sum += diff;
			}
		}
		list.add(Math.abs(sum - M));

		if (M <= sum) {
			// 올리기
			return sep(high, mid + 1);
		} else if (M > sum) {
			// 내리기
			return sep(mid - 1, low);
		}

		// 탐색 실패
		return -1;

	}*/

	private static long calMid(long high, long low) {

		long mid = (high + low) / 2;

		return mid;
	}
}
