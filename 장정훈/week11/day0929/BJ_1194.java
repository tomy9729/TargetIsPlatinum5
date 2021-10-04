package week12.day0929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1194 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int R,C;
	static char[][] map;
	static boolean[] getKey;
	static boolean[] hasKey;
	static int[][] deltas = {{-1,0},{1,0},{0,-1},{0,1}};
	
	public static void main(String[] args) throws IOException {
		//키의 개수는 2^6개로 생각한다.
		//비트연산을 이용해서
		//&연산일 때는 키를 가지고있는지 확인
		//|연산을 때는 키를 먹을 것으로 키를 가지고 있는 것으로 처리
//		System.out.println(1<<6);   
		st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		getKey = new boolean[6];
		hasKey = new boolean[6];
		for(int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0; j<map[i].length; j++) {
				if(map[i][j] == '0') {
					
				}
				if(0<= map[i][j]-'A' && map[i][j]-'A' < 'G') {
					
				}
			}
		}
		
	}
	
	private static boolean isIn(int nr, int nc) {
		return 0<=nr && nr<R && 0<=nc && nc <C;
	}
}
