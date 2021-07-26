package algol;

import java.util.Scanner;

public class Sugar_2839 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int kg = sc.nextInt();
		
		int Five = 0;
		int Three = 0;

		int answer = 0; 
		
		//최적의 방법
		if(kg%5%3 == 0) {
			Five = kg/5;
			Three = kg%5/3;
			answer = Five + Three;

		}else {
			// 5를 하나씩 줄여가며 검사
			for(int i=1;i<kg/5;i++) {
				Five = (kg/5)-i ;
				Three = (kg%5 + i*5)/3;
				if((kg%5 + i*5)%3 == 0) {
					answer = Five + Three;
					break;
				}
			}	
		}
		
		// 위에서 어떤 것도 해당되지 않을 경우 3만으로 검사
		if(answer == 0 && kg%3==0) {
			Three = kg/3;
			answer = Three;				
		}
		
		
		// 나누어 떨어지지 않을 때 
		if(answer == 0)
			answer = -1;
		
		
		System.out.println(answer);

	}

}
