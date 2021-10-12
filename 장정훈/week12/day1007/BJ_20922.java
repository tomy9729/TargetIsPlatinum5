package week13.day1007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_20922 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] input;
	static int[] num;
	static int N, K;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		input = new int[N];
		num = new int[100001];
		//1~100000숫자가 랜덤으로 들어온다
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		int max = 0;
		int start = 0;
		int end = 0;
		num[input[0]]++;
		for(int i=1; i<N; i++) {
			if(num[input[i]] < K) {
				//num에 있는 숫자를 증가 시킬 거라 같을 때 들어오면 K를 초과한다.
				num[input[i]]++;
//				end = i;
				max = Math.max(max, (i+1)-start);
			}else if(num[input[i]]==K){
//				for(int j=start; j<(i+1); j++) {
//					num[input[j]]--;
//					if(input[j]==input[i]) {
//						start = j; //j번째에 같은 숫자가 되니깐 start를 j다음에 위치시킨다.
//						break;
//					}
//				}
				while(true) {
					if(input[start]==input[i]) {
						start++;
						break;
					}else {
						num[input[start]]--;
						start++;
					}
				}
			}
		}
		System.out.println(max);
		
	}
}
