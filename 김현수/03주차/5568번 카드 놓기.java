//5568번 카드 놓기.java
package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class 카드_놓기_5568 {
	private static int n;
	private static int k;
	private static int[] nums;
	private static List<String> answer = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(bf.readLine());
		k = Integer.parseInt(bf.readLine());
		nums = new int[n];
		for(int i=0;i<n;i++) {
			nums[i]=Integer.parseInt(bf.readLine());
		}
		List<Integer> temp = new ArrayList<>();
		sol(k,temp);
		System.out.println(answer.size());
		
		
	}
	public static void sol(int count, List<Integer> k_nums) {
		if(count==0) {
			String result = new String();
			for(int i=0;i<k;i++) {
				result+=nums[k_nums.get(i)];
			}
			if(!answer.contains(result)) {
				answer.add(result);
			}
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(!k_nums.contains(i)) {
				k_nums.add(i);
				sol(count-1,k_nums);
				k_nums.remove(k_nums.size()-1);
			}
		}
	}
}
