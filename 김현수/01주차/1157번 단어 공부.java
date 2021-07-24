//1157번 단어 공부.java
import java.util.Arrays;
import java.util.Scanner;

public class 단어_공부_1157번 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		word = word.toUpperCase(); //toLowerCase();
		int[] count = new int[26];
		
		for(int i=0;i<word.length();i++) {
			count[(int)(word.charAt(i))-65]++;
		}
		
		int max=Arrays.stream(count).max().getAsInt();
		int max_count = 0;
		int index=0;
		
		for(int i=0;i<count.length;i++) {
			if(max == count[i]) {max_count++;index=i;}
		}
		
		if(max_count==1)System.out.println((char)(index+65));
		else System.out.println("?");
	}
}
