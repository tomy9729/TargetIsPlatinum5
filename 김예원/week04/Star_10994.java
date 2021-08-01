package algol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Star_10994 {

	
	static int N;
	static char[][] arr = null;
	static int row=0, col=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int k = (N-1)*4+1;
		arr = new char[k][k];

		for(char[] innerArr : arr) {
			for(int i=0;i<k;i++) {
				innerArr[i] = ' ';
			}
		}
		// 별찍기
				Star(k);
		for(char[] innerArr : arr) {
			System.out.println(innerArr);
		}
		
	}
	public static void Star(int c) {
		
		for(int j=row;j<c+row;j++) {
			if(j==row||j==c+row-1) {
				for(int i=col;i<c+col;i++) {
					arr[j][i] = '*';
				}
			}else {
					arr[j][col] = '*';
					arr[j][c+col-1] = '*';
			}
		}
		
		if(c==1) {
			arr[N*2-2][N*2-2] = '*';
			return;
		}
		row +=2;
		col +=2;
		c -= 4;
		Star(c);
		
	}

}
