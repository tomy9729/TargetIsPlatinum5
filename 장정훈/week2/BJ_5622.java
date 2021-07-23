package week2;

import java.util.Scanner;

public class BJ_5622 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		s.toUpperCase();
		int[] num = {3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,8,9,9,9,10,10,10,10};
		int res = 0;
		for(int i=0; i<s.length(); i++) {
			for(int j=0; j<26; j++) {
				if(s.charAt(i)==(char)(65+j)) {
					res += num[j];
				}
			}
		}
		System.out.println(res);
		sc.close();
	}

}
