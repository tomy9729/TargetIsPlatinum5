//1181번 단어 정렬.java
package week2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Word{
	public String w;
	public int len;
	
	Word(String w, int len){
		this.w = w;
		this.len = len;
	}
}

public class 단어_정렬_1181 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String word[] = new String[N];
		
		for(int i=0;i<N;i++) {
			word[i]=sc.next();
		}	
		
		Arrays.sort(word, new Comparator<String>() {
			@Override
			public int compare(String w1, String w2) {
				int l1 = w1.length();
				int l2 = w2.length();
				if(l1==l2)
					return w1.compareTo(w2);
				return l1<l2 ? -1 : 1;
			}
		});
		
		System.out.println(word[0]);
		for(int i=1;i<N;i++) {
			if(!word[i].equals(word[i-1]))System.out.println(word[i]);
		}
		
	}
}
