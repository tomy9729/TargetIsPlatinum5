//10815번 숫자 카드.java
package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자_카드_10815 {
	private static int N;
	private static int M;
	private static int[] card;
	private static int[] num;
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		card = new int[N];
		String line = br.readLine();
		StringTokenizer st = new StringTokenizer(line," ");
		for(int i=0;i<N;i++) {
			card[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(card);
		M = Integer.parseInt(br.readLine());
		num = new int[M];
		line = br.readLine();
		st = new StringTokenizer(line," ");
		for(int i=0;i<M;i++) {
			int checkNum = Integer.parseInt(st.nextToken());
			num[i]=searchNum(checkNum);
			sb.append(num[i]).append(" ");
		}
		System.out.println(sb.toString());
	}
	public static int searchNum(int num) {
		int left = 0;
		int right = card.length-1;
		int mid = (left+right)/2;
		while(left<=right) {
			if(card[mid]<num) {
				left=mid+1;
				mid = (left+right)/2;
			}
			else if(card[mid]>num) {
				right = mid-1;
				mid = (left+right)/2;
			}
			else {
				break;
			}
		}
		if(card[mid]==num)return 1;
		else return 0;
	}
}
