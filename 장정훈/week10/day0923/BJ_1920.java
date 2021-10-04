package week11.day0923;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1920 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] ary;
	static int N,M;
//	static String str;
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		ary = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			ary[i] = Integer.parseInt(st.nextToken());
//			str += st.nextToken();
		}
		Arrays.sort(ary);
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine()," ");
		for(int t=0; t<M; t++) {
			int n = Integer.parseInt(st.nextToken());
			if(contain(n)) {
				sb.append("1\n");
			}else {
				sb.append("0\n");
			}
		}
		System.out.println(sb.toString());
	}
	private static boolean contain(int n) {
		int l = 0;//ary[0];
		int r = ary.length-1;//ary[N-1];
		int mid =0;
		boolean flag = false;
		while(l<=r) {
			mid = (l+r)/2;
			if(ary[mid]==n) {
				flag = true;
				break;
			}
			else if(ary[mid] < n) {
				l = mid + 1;
			}else if(n < ary[mid]) {
				r = mid - 1;
			}
			
		}
		return flag;
	}
}
