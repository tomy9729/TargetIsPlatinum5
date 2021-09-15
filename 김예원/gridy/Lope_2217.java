package gridy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Lope_2217 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int num = 0;
		int sum = 0;
		int w =0;
		int max = -1;
		for(int i=0;i<N-1;i++) {
			int eq =0;	
			sum = 0;
			num = 1;
			w = arr[i];
			for(int j=i+1;j<N;j++) {
				num++;
				//sum += arr[i];				
				if(w==arr[j]) {
					eq++;
				}
			}
			
			sum = w*num;
			i += eq;
			
			if(max<sum) {
				max = sum;
			}
			
		}
		
		// 마지막 요소가 굉장히 큰 경우
		if(max<arr[arr.length-1]) {
			max = arr[arr.length-1];
		}
		
		System.out.println(max);
	}

}
