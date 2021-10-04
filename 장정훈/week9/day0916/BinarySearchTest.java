package week10.day0916;

import java.util.Arrays;

public class BinarySearchTest {

	public static void main(String[] args){
		int[] values = {3,11,15,20,21,45};
		
		System.out.println(Arrays.binarySearch(values, 3));//0
		System.out.println(Arrays.binarySearch(values, 45));//5
		System.out.println(Arrays.binarySearch(values, 11));//1
		System.out.println(Arrays.binarySearch(values, 30));//-6 30이 45 이전에 들어가면 정렬이 된다는 것을 알려줌 -6이면 5의 위치에 넣으면 된다.-(5)-1
		System.out.println(Arrays.binarySearch(values, 1));//-1(맨 앞에 넣어야 된다는 것을 알려줌-(0)-1)즉, 반환값이 -(넣어야되는 위치)-1이 된다.
		System.out.println(Arrays.binarySearch(values, 50));//-7 맨 뒤에 입력 되어야 되기 때문에 -(6)이고 거기에 -1을 해서 -7이 나온다.

		
		System.out.println(Arrays.binarySearch(values, 1,4,45));//1이상 4미만(3까지) 구간에서 45가 있으면 위치 반환, 없으면 삽입 위치 반환(-(?)-1)
	}
}
