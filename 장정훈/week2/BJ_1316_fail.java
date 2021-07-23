package week2;

import java.util.Scanner;

public class BJ_1316_fail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int cnt=0;
		boolean flag = true;
		String[] ary = new String[x];
		for(int i=0; i<x; i++) {
			ary[i] = sc.next();
			
		}
		for(int i=0; i<ary.length; i++) {
			
			label :for(int a=0; a<ary[i].length(); a++) {
				char t = ary[i].charAt(a);
				for(int b=a+1; b<ary[i].length(); b++) {
					if(t!=ary[i].charAt(b)) {
						for(int c=b+1; c<ary[i].length(); c++) {
							if(t==ary[i].charAt(c)) {
								flag=false;
								break label;
							}else {
								flag=true;
							}
						}
					}else {
						flag=true;
					}
				}
				
			}
			if(flag) {
				cnt++;
			}
		} 
		
		System.out.println(cnt);
	
	}

}
