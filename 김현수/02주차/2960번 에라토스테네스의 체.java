//2960번 에라토스테네스의 체.java
package week2;

import java.util.Arrays;
import java.util.Scanner;

public class 에라토스테네스의_체_2960 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		boolean isitprime[] = new boolean[N+1]; //삭제여부 확인 
		Arrays.fill(isitprime, true); //false면 삭제된 숫자
		
		int count=0;
		e : for(int i=2;i<=N;i++) { //2부터 시작
			if(isitprime[i]) { //삭제가 안된 숫자에 대해서
				int tmp=i;
				while(tmp<=N) { 
					if(isitprime[tmp]) {//삭제가 안되었을 때만 삭제
						isitprime[tmp]=false;
						count++;
						if(count==K) {
							System.out.println(tmp);//k번째로 삭제한 숫자면 출력
							break e;
						}
					}
					
					tmp += i;
				}
			}
		}
		
	}
}
