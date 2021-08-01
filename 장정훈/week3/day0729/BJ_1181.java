package week3.day0729;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class BJ_1181 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		List<String> strAry = new ArrayList<>();
		for(int i=0; i<x; i++) {
			String str = sc.next();
			strAry.add(str);
		}
		Collections.sort(strAry,new MyStringLengthComparator());
		List<String> resultAry = new ArrayList<>();
		for(String str: strAry) {
			if(!resultAry.contains(str)) {
				resultAry.add(str);
			}
		}
		for(String str : resultAry) {
			System.out.println(str);
		}
	}

}


class MyStringLengthComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		//return o1.compareTo(o2); -> 원래의 문자열이 비교되는 형태
		if(o1.length() == o2.length()) {
			return o1.compareTo(o2);
		}
		return Integer.compare(o1.length(), o2.length());
	}

	

}