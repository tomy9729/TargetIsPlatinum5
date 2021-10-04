package week10.day0916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DP2_LISTest2 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N]; //모든 원소의 값은 다르다.
		int[] LIS = new int[N];//해당 길이를 증가수열 중 맨 끝을 최소값으로 유지
		
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int size = 0;//LIS에 채워지고 있는 원소의 개수
		for (int i = 0; i < N; i++) {
			//중복값이 없으므로 항상 탐색 실패//음수값이 들어온다 -> 삽입위치로 환산하고자 하면 절대값 취하고 -1
			int temp = Math.abs(Arrays.binarySearch(LIS, 0, size, arr[i]))-1;
			
			LIS[temp] = arr[i];
			
			if(temp==size) {//추가된 위치가 맨 뒤라면 사이즈 증가.
				size++;
			}//다르면 뒤에 추가 된 게 아니어서 사이즈 증가X
		}
		System.out.println(size);
	}
	
	/*
	 * 
	 6
	 3 2 6 4 5 1
	 */

}
