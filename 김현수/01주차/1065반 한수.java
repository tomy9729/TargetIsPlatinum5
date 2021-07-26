//1065반 한수.java
import java.util.Scanner;

public class 한수_1065 {
	public static boolean hansoo(int num) {
		int[] arr;
		int index;
		if(num<100) return true;
		else if(num<1000) {arr = new int[3]; index = 2;}
		else return false;
		
		arr[2] = num%10;
		num /= 10;
		arr[1] = num%10;
		num /= 10;
		arr[0] = num;
		if(arr[1]-arr[0] == arr[2]-arr[1])return true;
		else return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = 0;
		for(int i =1;i<=N;i++) {
			if(hansoo(i))count++;
		}
		System.out.println(count);
	}
}
