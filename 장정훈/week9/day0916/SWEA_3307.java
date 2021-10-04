package week10.day0916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3307 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int TC = Integer.parseInt(br.readLine());
		for (int t = 1; t <= TC; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int[] LIS = new int[N];//각 원소를 끝으로 하는 최장길이
			st = new StringTokenizer(br.readLine()," ");
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int max = 0;//전체 중의 최대 길이
			for (int i = 0; i < N; i++) {
				LIS[i] = 1;
				for (int j = 0; j < i; j++) {//j -> i의 앞쪽 원소들
					if(arr[j] < arr[i] && LIS[i] < LIS[j]+1) {
						LIS[i] = LIS[j]+1;
					}
				}//i를 끝으로 하는 최장 길이 값 계산 완료
				if(max<LIS[i]) {
					max = LIS[i];
				}
			}//O(n^2)의 시간복잡도여서 n이 커지면 느려진다.
			
			sb.append("#"+t+" "+max+"\n");
		}
		System.out.println(sb.toString());
	}
}
