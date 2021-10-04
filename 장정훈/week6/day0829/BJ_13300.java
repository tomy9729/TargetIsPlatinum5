package week7.day0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_13300 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] bang;
	static int person;
	static int maxPerson;
	static int max;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		person = Integer.parseInt(st.nextToken());
		maxPerson = Integer.parseInt(st.nextToken());
		max = 0;
		bang = new int[7][2];//1~6학년, 남여
		for(int i=0; i<person; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int sex = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			bang[grade][sex]++;
		}
		for(int i=1; i<=6; i++) {
			for(int j=0; j<2; j++) {
				max += bang[i][j]/maxPerson;
				if(bang[i][j]%maxPerson !=0) {
					max++;
				}
			}
		}
		System.out.println(max);
	}

}
