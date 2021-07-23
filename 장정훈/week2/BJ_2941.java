package week2;

import java.util.Scanner;

public class BJ_2941 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int len = s.length();
		int cnt = 0;
		for(int i=0; i<len; i++) {
			if(i+1 <len) {
				if(s.charAt(i)=='c') {
				
					if((s.charAt(i+1)=='=') || (s.charAt(i+1)=='-')) {
						
						i++;
					}
				
				}else if(s.charAt(i)=='d') {
					
					if(s.charAt(i+1)=='-') {
						
						i++;
					}else if((i+2)<s.length()&&(s.charAt(i+1)=='z'&&s.charAt(i+2)=='=')) {
						//런타임 에러를 잡기위해 괄호로 우선순위 처리를 해줌.
						i+=2;
				
					}
					
				}else if((s.charAt(i)=='l')||(s.charAt(i)=='n')) {
					
					if(s.charAt(i+1)=='j') {
						
						i++;
					}
					
				}else if((s.charAt(i)=='s')||(s.charAt(i)=='z')) {
						
					if(s.charAt(i+1)=='=') {
						
						i++;
					}
					
				}
				cnt++;
				
			}else {
				cnt++;
			}
		}
		System.out.println(cnt);
		sc.close();
	}

}
