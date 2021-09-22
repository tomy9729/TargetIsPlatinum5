package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2470 {

	static int N;
	static long[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		
		arr = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			long a = Integer.parseInt(st.nextToken());
			arr[i] = a;
		}
		
		// 배열 오름차순 정렬
		Arrays.sort(arr);

		// 가장 앞, 뒤를 가리킬 index
		int front = 0; int rear = arr.length - 1;
		
		// 최솟값을 저장
		long min = Integer.MAX_VALUE;
		// 최솟값을 만드는 두 수 저장
		long num1=0; long num2=0;

		while (front < rear) {

			long a = arr[front]; long b = arr[rear];

			// 최솟값 판별
			long sum = a + b;
			if (Math.abs(sum) < min) {
				min = Math.abs(sum);
				num1 = a; num2 = b;
			}

			// 0이면 그대로 종료
			if (sum == 0) {
				break;
			} else if (sum > 0) {
				// sum값이 0보다 큰 경우에는 꼬리를 하나 앞당김
					rear--;
			} else {
				// sum값이 0보다 작은 경우에는 머리를 뒤로 밀어줌
					front++;
			}

		}
		
		sb.append(num1).append(" ").append(num2);

		System.out.println(sb.toString());
	}

}
