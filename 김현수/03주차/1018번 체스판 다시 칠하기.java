//1018번 체스판 다시 칠하기.java
package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 체스판_다시_칠하기_1018 {
	private static int M;
	private static int N;
	private static char[][] board;
	private static char[][] chessW = {
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'}
	};
	private static char[][] chessB = {
			{'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'},
			{'B','W','B','W','B','W','B','W'},
			{'W','B','W','B','W','B','W','B'}
	};
	private static int answer=64;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = new String();
		line = br.readLine();
		StringTokenizer st = new StringTokenizer(line," ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		board = new char[M][N];
		
		for(int i=0;i<M;i++) {
			line = br.readLine();
			for(int j=0;j<N;j++) {
				board[i][j]=line.charAt(j);
			}
		}
		
		for(int i=0;i<M-7;i++) {
			for(int j=0;j<N-7;j++){
				int tempW=0;
				int tempB=0;
				for(int m=i;m<i+8;m++) {
					for(int n=j;n<j+8;n++) {
						if(board[m][n]!=chessW[m-i][n-j])tempW++;
						if(board[m][n]!=chessB[m-i][n-j])tempB++;
					}
				}
				answer = (((tempW<tempB)? tempW:tempB) < answer) ? ((tempW<tempB)? tempW:tempB) : answer;
			}
		}
		System.out.println(answer);
	}
}
