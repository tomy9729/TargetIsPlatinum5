//2941번 크로아티아 알파벳.java
import java.util.Scanner;

public class 크로아티아_알파벳_2941 {
	public static void main(String[] args) {
		String[] croatia = {"c=","c-","d-","lj","nj","s=","z="};
		
		
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		int count = word.length();
		for(int i=0;i<word.length()-1;i++) {
			String c_word = Character.toString(word.charAt(i))+Character.toString(word.charAt(i+1));
			for(String c : croatia) {
				if(c_word.equals(c))count--;
			}
		}
		for(int i=0;i<word.length()-2;i++) {
			String c_word = Character.toString(word.charAt(i))+Character.toString(word.charAt(i+1))+Character.toString(word.charAt(i+2));
			if(c_word.equals("dz="))count--;
		}
		System.out.println(count);
	}
}
