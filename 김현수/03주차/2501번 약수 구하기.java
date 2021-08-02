//2501번 약수 구하기.java
package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 약수_구하기_2501 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<Integer>measure = new ArrayList<>();
		
		for(int i=1;i*i<=N;i++) {
			if(N%i==0) {
				if(i*i==N) {
					measure.add(i);
				}
				else {
					measure.add(i);
					measure.add(N/i);
				}
			}
		}
		Collections.sort(measure);
		if(measure.size()>=K)	System.out.println(measure.get(K-1));
		else System.out.println(0);
	}
}
