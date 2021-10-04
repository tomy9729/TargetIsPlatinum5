package week6.day0817;

import java.util.Arrays;

public class BinarySearchTest {

	public static void main(String[] args) {
		int[] arr = {10,4,6,20,35,7};
		Arrays.sort(arr);
		System.out.println(binarySearch(arr, 6));
	}
	static int binarySearch(int[] arr, int key) {//탐색한 배열, 찾을 키.
		int start =0, end = arr.length-1;
		
		while(start<=end) {
			int mid = (start+end)/2; //중간위치
			if(arr[mid] == key) {
				return mid;
			}else if(arr[mid]<key) {
				start = mid +1;
			}else {
				end = mid-1;
			}
		}
		return -1;
	}
}
