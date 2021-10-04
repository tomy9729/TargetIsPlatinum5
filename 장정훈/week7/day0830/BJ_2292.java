package week8.day0830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2292 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int find = Integer.parseInt(br.readLine());
		if (find == 1) {
			System.out.println(1);
		} else {
			int answer=1;
			int i = 1;
			int cnt = 2;
			while (true) {
				if (find <= 6 * (i)+1) {
					break;
				}
				i += cnt;
				cnt++;
				answer++;
			}
			System.out.println(answer+1);
		}
	}

}
