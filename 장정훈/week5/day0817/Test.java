package week6.day0817;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		String[] strAry = {"abcc","abc","abd"};
		System.out.println(Arrays.toString(strAry));
		
		Arrays.sort(strAry);
		System.out.println(Arrays.toString(strAry));
	}
	static class person{
		int age;
		int kg;
		int cm;
		String name;
	}

}
