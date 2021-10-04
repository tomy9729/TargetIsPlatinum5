package week6.day0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_2170_0818Re {

	static BufferedReader br;
	static StringTokenizer st;
	static int N,sum;
	static int[] ary;
	static List<int[]> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		ary = new int[2];
		list = new ArrayList<>();
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine()," ");
			list.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
			
		}

		for(int i=0; i<N; i++) {
			int[] arr= list.get(i);
			
		}
		
		System.out.println(sum);
		
	}

}
