//1316번 그룹 단어 체커.java
import java.util.Scanner;

public class 그룹_단어_체커_1316 {
	public static boolean group_word(String word) {
		int[] check = new int[26];
		check[(int)word.charAt(0)-97] = 1;
		for(int i=1;i<word.length();i++) {
			if(word.charAt(i)!=word.charAt(i-1) && check[(int)word.charAt(i)-97]==1)return false;
			check[(int)word.charAt(i)-97]=1;
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		int count = 0;
		
		for(int i=0;i<N;i++) {
			String word = sc.nextLine();
			if(group_word(word))count++;
		}
		System.out.println(count);
	}
}
