package week2;

import java.util.Scanner;

public class BJ_15596_TestClass {

	 long sum(int[] a) {
		long res =0;
		for(int i=0; i<a.length; i++) {
			res += a[i];
		}
		
		return res;
	}

}
