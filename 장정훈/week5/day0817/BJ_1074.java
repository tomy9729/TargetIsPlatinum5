package week6.day0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1074 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, R, C;
	static int copyN;
	static int find;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		halfNhalf(0, 0,(int)Math.pow(2, N));// (0,0)에서 시작

	}

	private static void halfNhalf(int i, int j, int len) {
		if(len==1) {
			if(i==R && j==C){
				System.out.println(find);
				System.exit(0);
			}else {
				find++;
			}
			return;
		}
		
		//영역 내부에 내가 찾으려는 지점이 없다면 그냥 곱하기로 퉁
		if(!(i<=R && R<i +len&&j<=C && C<j+len)) {
			find += len*len;
			return;
		}
		
		//4분할 탐색을 재귀적으로
		int next = len/2;
		halfNhalf(i, j, next);//왼쪽 위
		halfNhalf(i, j+next, next);//오른쪽 위
		halfNhalf(i+next, j, next);//왼쪽 아래
		halfNhalf(i+next, j+next, next);//오른쪽 아래
		
	}

}
