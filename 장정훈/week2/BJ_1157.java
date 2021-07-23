package week2;

import java.util.Scanner;

public class BJ_1157 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		s = s.toUpperCase();
		int[] cnt = new int[26];
		
		for(int i=0; i<s.length(); i++) {
			for(int j=0; j<26; j++) {
				if(s.charAt(i)==(char)(65+j)) {
					cnt[j] += 1;
				}
			}
		}
		int maxcnt = -1;
		int maxary = 0;
		int a = 0;
		for(int i=0; i<cnt.length; i++) {
			if(maxcnt<cnt[i]) {
				maxcnt = cnt[i];
				maxary = i;
				a = 0;
			}else if(maxcnt == cnt[i]) {
				a += 1;
			}
		}
		if(a == 0) {
			System.out.printf("%c",65+maxary);
		}else {
			System.out.println("?");
		}
		
		
		sc.close();
	}

}
