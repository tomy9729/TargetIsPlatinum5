//10989번 수 정렬하기.java
package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수_정렬하기_10989 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int num[]=new int[10001];
		for(int i=0;i<N;i++) {
			num[Integer.parseInt(br.readLine())]++;
		}
		for(int i=1;i<10001;i++) {
			if(num[i]!=0) {
				for(int j=0;j<num[i];j++) {
					sb.append(i).append('\n');
				}
			}
		}
		System.out.println(sb.toString());
	}
}
