//5622번 다이얼.java
import java.util.Scanner;

public class 다이얼_5622 {
	public static int number(char character) {
		int result = 2;
		switch(character) {
			case 'A' :
			case 'B' :
			case 'C' :
				result = 3;
				break;
			case 'D' :
			case 'E' :
			case 'F' :
				result = 4;
				break;
			case 'G' :
			case 'H' :
			case 'I' :
				result = 5;
				break;
			case 'J' :
			case 'K' :
			case 'L' :
				result = 6;
				break;
			case 'M' :
			case 'N' :
			case 'O' :
				result = 7;
				break;
			case 'P' :
			case 'Q' :
			case 'R' :
			case 'S' :
				result = 8;
				break;
			case 'T' :
			case 'U' :
			case 'V' :
				result = 9;
				break;
			case 'W' :
			case 'X' :
			case 'Y' :
			case 'Z' :
				result = 10;
				break;		
		}
		return result;				
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		int ans = 0;
		for(int i=0;i<word.length();i++) {
			ans += number(word.charAt(i));
		}
		System.out.println(ans);
	}
}
