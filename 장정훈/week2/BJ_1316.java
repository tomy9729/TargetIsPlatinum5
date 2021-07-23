package week2;

import java.util.Scanner;

public class BJ_1316 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int cnt=0;
		String[] ary = new String[x];
		
		for(int i=0; i<x; i++) {
			ary[i] = sc.next();
			
		}
		for(int i=0; i<ary.length; i++) {
			if(check(ary[i])) {
				cnt++;
			}
		}
		
		
		System.out.println(cnt);
		sc.close();
	}
	public static boolean check(String str) {
		boolean flag[] = new boolean[26];
		for(int i=0; i<26; i++) {
			flag[i] = false;
		}
		for(int i=0; i<str.length(); i++) {
			if(flag[str.charAt(i)-'a'] ==true) {
				return false;
			}else {
				char text = str.charAt(i);
				flag[str.charAt(i)-'a'] = true;
				for(int j=i+1; j<str.length(); j++) {
					if(text==str.charAt(j)) {
						i++;
					}else {
						break;
					}
				}


	
			}
		}
		return true;
	}

}
