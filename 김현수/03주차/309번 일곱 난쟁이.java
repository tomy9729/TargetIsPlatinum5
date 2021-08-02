//2309번 일곱 난쟁이.java
package week3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 일곱_난쟁이_2309 {
	private static int[] people = new int[9];
	private static List<Integer> answer = new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<9;i++) {
			people[i] = sc.nextInt();
		}
		List<Integer> temp = new ArrayList<>();
		back(temp,0);
		answer = answer.subList(0, 7);
		Collections.sort(answer);
		for(Integer i : answer)System.out.println(i);
		
	}
	public static void back(List<Integer> arr, int size) {
		if(size>8)return;
		if(size==7 && arr.stream().mapToInt(Integer::intValue).sum()==100) {
			for(Integer i : arr)answer.add(i);
			return;
		}
		for(int i=size;i<9;i++) {
			if(!arr.contains(people[i])) {
				arr.add(people[i]);
				back(arr,size+1);
				arr.remove(arr.size()-1);
			}
		}
	}
	
}
