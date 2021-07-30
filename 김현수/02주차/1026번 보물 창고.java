//1026번 보물 창고.java
package week2;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class 보물_1026 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		List<Integer> A = new ArrayList<Integer>();
		List<Integer> B = new ArrayList<Integer>();
		
		for(int i=0;i<N;i++) A.add(sc.nextInt());
		for(int i=0;i<N;i++) B.add(sc.nextInt());
		
		A.sort(Comparator.naturalOrder());
		B.sort(Comparator.reverseOrder());
		
		int result=0;
		for(int i=0;i<N;i++) result+=A.get(i)*B.get(i);
		
		System.out.println(result);
	}
}
