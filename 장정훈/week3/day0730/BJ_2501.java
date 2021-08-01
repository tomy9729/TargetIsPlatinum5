package week3.day0730;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BJ_2501 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		List<Integer> ary = new ArrayList<>();
		for(int i=1; i<x+1; i++) {
			if(x%i==0) {
				ary.add(i);
			}
		}
		if(ary.size()<y) {
			System.out.println("0");
		}else {
			Collections.sort(ary);
			int ans = ary.get(y-1);
			System.out.println(ans);
		}
		
		
	}

}
