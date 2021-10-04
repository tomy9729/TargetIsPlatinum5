package week9.day0908;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_5904 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int target;
	static char answer;
	static int[] numAry;
	public static void main(String[] args) throws NumberFormatException, IOException {
		target = Integer.parseInt(br.readLine());
		if(target == 1) {
			System.out.println('m');
		}else if(target == 2 || target==3) {
			System.out.println('o');
		}else {
			numAry = new int[30];//10^9까지라 2^30
			numAry[0] = 3;//0일 때 최대 길이 3
			for(int i=1; i<30; i++) {
				numAry[i] = numAry[i-1] + (1+i+2) + numAry[i-1];
			}
			moo(target);
			System.out.println(answer);
		}
	}

	private static void moo(int target) {
		if (target == 1) {
			answer = 'm';
			return;
		}
        if (target == 2 || target == 3) {
        	answer = 'o';
        	return;
        }
		int i=1;
		while(numAry[i]<target) {
			i++;
		}
		
		if(numAry[i]==target) {
			answer = 'o';//제일 끝
			return;
		}
		if(numAry[i-1]+1==target) {
			answer='m';//새로운 moo시작 지점
			return;
		}
		if(numAry[i-1]+1<target&&target<=numAry[i-1]+1+i+2) {
			answer ='o';//새로운 moo의 o지점
			return;
		}
		moo(target-numAry[i-1]-(i+3));
		
	}

}
