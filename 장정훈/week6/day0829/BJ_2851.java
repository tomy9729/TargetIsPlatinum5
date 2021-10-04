package week7.day0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2851 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int Max;
	static int sum;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		Max = Integer.MIN_VALUE;
		sum = 0;
		for(int i=0; i<10; i++) {
			int next = Integer.parseInt(br.readLine());
			sum += next;
			if(sum==100) {
				Max = 100;
				break;
			}else if(sum > 100) {
				if( sum - 100 <= 100 - (sum -next)) {
					Max = sum;
				}else{
					Max = sum-next;
				}
				break;
			}else {
				Max = Math.max(Max, sum);
			}
		}
		System.out.println(Max);
	}
	
}
