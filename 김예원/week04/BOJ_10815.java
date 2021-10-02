package algol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import javax.management.loading.MLet;

public class NumberCard {

	/*방법1 : 이분 검색
	방법2 : map으로 key가 있는지 검색
	
	방법2가 더 빠름*/
	static int N;
	static int[] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		/*arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		*/
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<String, Boolean> map = new HashMap<>();
		for(int i=0;i<N;i++) {
			map.put(st.nextToken(), true);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			if(map.containsKey(st.nextToken())) {
				sb.append(1).append(" ");
			}else {
				sb.append(0).append(" ");
			}
		}
		
		/*int M = Integer.parseInt(br.readLine());
		int[] result = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			if(binarySearch(Integer.parseInt(st.nextToken()))) {
				result[i]=1;
			}else{
				result[i]=0;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++) {
			sb.append(result[i]).append(" ");
		}
		*/
		System.out.println(sb.toString());
	}
	public static boolean binarySearch(int num) {
		
		int left = 0;
		int right = N-1;
		while(left<=right) {
			int mid = (left+right)/2;
			int midNum = arr[mid];
			if(midNum<num) {
				left = mid+1;
			}else if(midNum>num) {
				right = mid-1;
			}else
				return true;
		}
		return false;
	}

}
