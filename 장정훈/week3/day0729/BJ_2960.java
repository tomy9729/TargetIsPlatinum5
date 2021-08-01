package week3.day0729;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BJ_2960 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		//int[] ary = new int[x-1];//2부터 넣을 거라
		List<Integer> list = new ArrayList<Integer>();
		for(int i=2; i<x+1; i++) {
			list.add(i);
		}
		int i=0;
		int ans =0;
		int ex = 0;
		ch :while(true) {
			if(i==y) {
				break;
			}
			
			ex = list.get(0);
			
			
				for(int j=0; j<list.size(); j++ ) {
					
					if(list.get(j)%ex==0) {
						
						ans = list.get(j);
						list.remove(j);
//						System.out.println("after"+list.toString()+(i+1)+"번째 "+"remove num =>"+ans);
						i++;
						if(i==y) {
							break ch;
						}
						j--;
					}
					
				
			}
			
		}
		
		System.out.println(ans);
		sc.close();
	}

}
