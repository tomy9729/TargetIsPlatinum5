 package week6.day0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14501_2 {

	static BufferedReader br;
	static StringTokenizer st;
	static DAY[] days;
	static int N;// 퇴사일-1
	static int Max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		days = new DAY[N + 1];// 헷갈리지 않기 위해 1일부터 시작
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			days[i] = new DAY(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		} // 입력 완료.
		
		System.out.println(Max);
	}

	

	static class DAY {

		int time;
		int money;

		public DAY(int day, int time) {
			super();
			this.time = day;
			this.money = time;
		}

	}

}
