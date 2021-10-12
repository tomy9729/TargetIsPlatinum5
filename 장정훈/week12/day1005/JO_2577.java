package week13.day1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO_2577 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, d, k, c;
	// 벨트에 놓여진 초밥 N, 초밥의 종류 d, 연속해서 먹을 때 할인 받는 개수 k, 쿠폰 c
	static int[] rail;// 벨트에 있는 초밥을 넣는 배열
	static int[] dAry;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		rail = new int[N];
		for (int i = 0; i < N; i++) {
			rail[i] = Integer.parseInt(br.readLine());
		}
		dAry = new int[d + 1];
		int max = 0;
		int sum = 0;
		for (int j = 0; j < k; j++) {
			int jj = j % N;
			if (dAry[rail[jj]] == 0) {
				sum++;
			}
			dAry[rail[jj]]++;
		}//0~k까지의 종류의 최대 수를 구한다.
		max = sum;
		for (int i = 0; i < N; i++) {
			if(dAry[rail[(i+k)%N]] == 0) {
				sum++;
			}//i+k번째의 숫자가 0이면 아직 안 먹은 종류의 초밥이므로 +1을 하고
			dAry[rail[(i+k)%N]]++;//먹었음을 표시
			dAry[rail[i]]--;//i번째는 밀리면서 사용한 초밥의 개수를 -1해줌.
			if(dAry[rail[i]]==0) {//-1 해줬는데 0이 되버리면 사용 못 한 종류의 초밥이 되므로 전체 합에서 -1을 해준다.
				sum--;
			}
			if(max<=sum) {//새롭게 구한 초밥 가짓수아 원래의 조합보다 많이 사용하거나 같으면(이때 같을 때도 확인하는 이유는 c번 초밥을 안 먹었을 때 더 커지기 때문)
				if(dAry[c]==0) {
					max = sum +1;
				}else {
					max = sum;
				}
			}
			
		}
		
		System.out.println(max);
	}
}
