//17829번 222-풀링.java
package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 풀링_222_17829 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		int[][] square = new int[N][N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<N;j++) {
				square[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		while(N!=1) {
			N /= 2;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					int[] temp = new int[4];
					temp[0]=square[2*i][2*j];
					temp[1]=square[2*i+1][2*j];
					temp[2]=square[2*i][2*j+1];
					temp[3]=square[2*i+1][2*j+1];
					Arrays.sort(temp);
					square[i][j]=temp[2];
				}
			}
		}
		System.out.println(square[0][0]);
	}
}
