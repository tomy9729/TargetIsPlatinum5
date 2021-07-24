package com.ssafy.algol;

import java.util.Scanner;

public class GroupWord {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.nextLine();
		int result = 0;
		
		for(int count=0;count<num;count++) {
			String string = sc.nextLine();
			
			
			
			char[] charArr = string.toCharArray();
			char[] tempArr = new char[charArr.length];
			
			//중복 제거
			int temp = 0;
			tempArr[temp] = charArr[0];
			in : for(int i=1;i<charArr.length;i++){
				if(charArr[i]==tempArr[temp]) {
					charArr[i] = ' ';
					continue in;
				}else {
					temp++;
					tempArr[temp] = charArr[i];
				}
			}
			// 하나 남은 문자들 새로운 배열에 
			int sort = 0;
			result++;
			group : for(int i=0;i<charArr.length-1;i++){
				if(charArr[i]!=' ') {
					for(int j=i+1;j<charArr.length;j++) {
						if(charArr[i]==charArr[j]) {
							result--;
							break group;
						}
					}
				}
			}
			
		}
		System.out.println(result);
	}
}
