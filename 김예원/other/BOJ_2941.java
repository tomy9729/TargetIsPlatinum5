package com.ssafy.algol;

import java.util.Scanner;

public class Croatia {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String string = sc.nextLine();
		
		char[] charArr = string.toCharArray();
		
		int result = 0; // 결과
		int i=0; //index
		while(i<charArr.length-1) {
			
			// 'dz=' 검사
			if((i+3)<=charArr.length && charArr[i]=='d'&&charArr[i+1]=='z' && charArr[i+2]=='=') {
				i += 2;
			} else {
				//"c=", "c-", "d-", "lj", "nj","s=","z=" 검사
				switch(charArr[i]) {
				case 'c':
					if(charArr[i+1]=='=' ||charArr[i+1]=='-') {
						i += 1;
					}
					break;
				case 'd':
					if(charArr[i+1]=='-') {
						i += 1;
					}
					break;
				case 'l':
				case 'n':
					if(charArr[i+1]=='j') {
						i += 1;
					}
					break;
				case 's':
				case 'z':
					if(charArr[i+1]=='=') {
						i += 1;
					}
				}
				
			}
			
			
			i++;
			result++;
		}
		
		// 마지막이 크로아티아 알파벳이 아닐 경우
		if(i==charArr.length-1)
			result++;
		
		
		System.out.println(result);
		
	}

}
