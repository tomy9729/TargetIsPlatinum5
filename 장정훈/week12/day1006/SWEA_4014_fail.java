package week13.day1006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_4014_fail {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int result;
	static int N, X;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			result = 0;
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.println(t);
			play();

			sb.append("#" + t + " " + result + "\n");
		}
		System.out.println(sb.toString());
	}

	private static void play() {
		int[] arr;

		for (int i = 0; i < N; i++) {
			arr = new int[N];
			for (int j = 0; j < N; j++) {
				arr[j] = map[i][j];
			}
			solve(arr);
		}

		for (int j = 0; j < N; j++) {
			arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = map[i][j];
			}
			solve(arr);
		}

	}

	private static void solve(int[] arr) {

		boolean flag = false;
		int start = arr[0];
		for (int i = 0; i < N; i++) {
			if (arr[i] != start) {
				flag = true;
			}
		}
		if (!flag) {
			result++;
			return;
		}
		int[] visitied = new int[N];
		int[] window = new int[7];
		// -,1,2,3,4,5,6
		// 오르막을 확인하기 위한 윈도우;
		for (int i = 0; i < X; i++) {
			window[arr[i]]++;
		}
		int c = 0;
		for (int i = 0; i < X; i++) {
			if (window[i] == 0 || window[i] == X) {
				flag = true;
			}
			if (window[i] != 0) {
				c++;
			}
		}
		if (c > 2) {
			flag = false;
		}
		if (X == 2) {
			if (c == 2) {
				flag = false;
			}
		}
		if (flag) {
			for (int i = X; i < N; i++) {
				if (arr[i] - 1 == arr[i - 1]) {
					if (window[arr[i - 1]] == X) {
						// 오르막을 만들 수 있는 거리가 충분히 된다면.
						for (int j = i - X; j < i; j++) {
							visitied[j]++;
						}
						flag = true;
					} else {
						flag = false;
					}
				} else if (arr[i] - 1 > arr[i - 1]) {
					return;// 볼 필요가 없음
					// arr[i] 가 3이고 arr[i-1]이 1인 경우이다.
					// ....1 1 3 3 -> X가 2라고 하더라도 올라갈 수 없다.
				}
				window[arr[i]]++;
				window[arr[i - 1]]--;

			}

			if (flag) {
				arr = reverse(arr);
				visitied = reverse(visitied);
				window = new int[7];
				// -,1,2,3,4,5,6
				// 오르막을 확인하기 위한 윈도우;
				for (int i = 0; i < X; i++) {
					window[arr[i]]++;
				}
				c = 0;
				for (int i = 0; i < X; i++) {
					if (window[i] == 0 || window[i] == X) {
						flag = true;
					}
					if (window[i] != 0) {
						c++;
					}
				}
				if (c > 2) {
					flag = false;
				}
				if (X == 2) {
					if (c == 2) {
						flag = false;
					}
				}
				if (flag) {
					for (int i = X; i < N; i++) {

						if (arr[i] - 1 == arr[i - 1]) {
							if (window[arr[i - 1]] == X) {
								// 오르막을 만들 수 있는 거리가 충분히 된다면.
								for (int j = i - X; j < i; j++) {
									visitied[j]++;
								}
								flag = true;
							} else {
								flag = false;
							}
						} else if (arr[i] - 1 > arr[i - 1]) {
							return;// 볼 필요가 없음
							// arr[i] 가 3이고 arr[i-1]이 1인 경우이다.
							// ....1 1 3 3 -> X가 2라고 하더라도 올라갈 수 없다.
						}
						window[arr[i]]++;
						window[arr[i - 1]]--;

					}
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (visitied[i] > 1) {
				flag = false;
			}
			if (visitied[i] == 1) {
				cnt++;
			}
		}
		if (cnt == 0) {
			flag = false;
		}
		if (flag) {
			System.out.println(Arrays.toString(arr));
			System.out.println(Arrays.toString(visitied));
			System.out.println();
			result++;
		}
	}

	private static int[] reverse(int[] arr) {
		int[] reverse = new int[arr.length];

		int i = 0;
		for (int j = arr.length - 1; j >= 0; j--) {
			reverse[i++] = arr[j];
		}

		return reverse;
	}
}
