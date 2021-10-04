package week6.day0821;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14501 {

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
		Max = Integer.MIN_VALUE;
		boolean flag = true;
		int z = 1;
		while (z <= N) {
			int sum = 0;
			for (int i = z; i <= N;) {

				if (days[i].time == 1) {// 마지막 날이어도 상담 받는 날이 하루면 받을 수 있음.
					sum += days[i].money;
					i++;
					continue;
				}
				if (i + (days[i].time - 1) <= N) {
					int[] semi = find(i);
					if (semi[0] == i) {
						sum += days[i].money;
						i = i + days[i].time;
					} else {
						sum += semi[1];
						i = i+ semi[0]+days[semi[0]].time;
					}
					continue;
				}
				i++;
			}
			Max = Math.max(Max, sum);
			z++;
		}
		System.out.println(Max);
	}

	private static int[] find(int fi) {
		int z = fi;
		int[] arr = new int[2];
		int r = fi;
		int m = Integer.MIN_VALUE;
		while (z <= N) {
			int sum = 0;
			for (int i = z; i <= N;) {

				if (days[i].time == 1) {// 마지막 날이어도 상담 받는 날이 하루면 받을 수 있음.
					sum += days[i].money;
					i++;
					continue;
				}
				if (i + (days[i].time - 1) <= N) {

					sum += days[i].money;
					i = i + days[i].time;

					continue;
				}
				i++;
			}
			if (m < sum) {
				m = sum;
				r = z;
			}
			m = Math.max(m, sum);
			z++;
		}
		arr[1] = m;
		arr[0] = r;
		return arr;
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
