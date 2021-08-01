package week3.day0730;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_2309 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] fake = new int[9];
		int sum =0;
		for(int i=0; i<9; i++) {
			fake[i]=sc.nextInt();
			sum += fake[i];
		}
		Arrays.sort(fake);
			ch : for(int j=1; j<5; j++) {
				for(int i=0; i<9; i++) {
					//nCr = n!/r!(n-r)! -> i는 n이고 j는 nCr / n을 해서 나온 결과물
					//=> 9C7 (9가지 중에서 7개를 가지고 조합을 만는다) => 36
					// 또는 9가지 중에서 2개를 가지고 조합을 만든다고 생각해도 같다.
					// i+j로 i는 0~8로 fix j는 경우의 수를 만드는 것. 즉, 36/9 = 4가지
					int a = i + j; //i+j가 i보다 크게 나올 수 있다.
					// 그렇기 때문에 i의 최대값이 8보다 클 때를 if문으로 처리해준다.
					// 배열은 0부터 시작하기 때문에 i+j가 최대를 넘어갈 때에 맞춰서 0으로 바꿔줄 수 있도록 한다. 
					if(a>8) {
						a = (a+1)%10;
					}
					
					if((sum-(fake[i]+fake[a])) == 100) {
						fake[i] =0;
						fake[a]=0;
						break ch;
					}
				}
			}
		
		for(int i=0; i<9; i++) {
			if(fake[i]!=0) {
				System.out.println(fake[i]);
			}
		}
		
		
		
	}

}
