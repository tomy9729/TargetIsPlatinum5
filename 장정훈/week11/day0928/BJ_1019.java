package week12.day0928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1019 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static long A;

	public static void main(String[] args) throws IOException {
//		
		
		A = Long.parseLong(br.readLine());

		long[] result = sum(A);

		for(long a : result) {
			sb.append(a+" ");
		}
		System.out.println(sb.toString());
	}

	private static long[] sum(long n) {
		
		long[] ary = new long[10];
		long s = 1, sum = 0, t, r;
		while (n > 0) {
			t = n / (s * 10);//10^?
			r = n % (s * 10);//10^?
			for (int i = 0; i < 10; i++) {
				ary[i] += t * s;
			}
			for (int i = 1; i <= r / s; i++) {
				ary[i] += s;
			}
			ary[(int) ((r / s + 1) % 10)] += r % s;
			n -= 9 * s;
			s *= 10;
		}
		for (int i = 1; i < 10; i++) {
			sum += i * ary[i];
		}

		return ary;
	}
}
