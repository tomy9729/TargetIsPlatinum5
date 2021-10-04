package week9.day0910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2630 {

	static BufferedReader br;
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static char[][] map;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				map[i][j] = st.nextToken().charAt(0);
			}
		}

		find(0, 0, N);
		String str = sb.toString();
		sb = new StringBuilder();
		int iCnt =0;
		int jCnt =0;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)=='0') {
				iCnt++;
			}else if(str.charAt(i)=='1') {
				jCnt++;
			}
		}
		sb.append(iCnt+"\n"+jCnt);
		System.out.println(sb.toString());
	}

	private static void find(int i, int j, int cnt) {
		if(pressure(i, j, cnt)) {
			sb.append(map[i][j]);
		}else {
			int half = cnt / 2;
			sb.append("(");
			find(i,j,half);
			find(i,j+half,half);
			find(i+half,j,half);
			find(i+half,j+half,half);
			sb.append(")");
		}
	}

	private static boolean pressure(int i, int j, int cnt) {
		boolean flag = true;
		
		out: for(int x=i; x<i+cnt; x++) {
			for(int y=j; y<j+cnt; y++) {
				if(map[i][j]!=map[x][y]) {
					flag = false;
					break out;
				}
			}
		}
		
		return flag;
	}

}
