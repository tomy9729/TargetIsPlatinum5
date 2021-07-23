package week2;

import java.util.Scanner;

public class BJ_10809 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int[] res = new int[26];
		for(int i=0; i<26; i++) {
			res[i] = -1;
		}
		for(int i=0; i<s.length();i++) {
			for(int j=0; j<26; j++) {
				if(s.charAt(i)==(char)(97+j)) {
					if(res[j]!=-1) {
						continue;
					}
					res[j]=i;
				}
			}
		}
		
		for(int i=0; i<res.length; i++) {
			System.out.printf("%d ",res[i]);
			
		}
		

		sc.close();
	}

}
