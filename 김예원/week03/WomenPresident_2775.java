package algol;

import java.util.Scanner;

public class WomenPresident_2775 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] kn = new int[N][N];
		
		int k=0;
		int n=0;
		
		for(int testCase=0;testCase<N;testCase++) {
			kn[testCase][0] = sc.nextInt();
			kn[testCase][1] = sc.nextInt();		
		}
		
		for(int testCase=0;testCase<N;testCase++) {
			int answer = 0;
			k = kn[testCase][0];
			n = kn[testCase][1];
			
			int[] arr = new int[n+1];
			for(int i=1;i<=n;i++) {
				arr[i] = i;
			}
			
			
			int[] newArr = new int[n+1];
			
			
			
			for(int i=0;i<k-1;i++) {
				
				if(2<=n) {
					newArr = array(arr,n);
					arr = newArr;
				}
				
			}

			for(int l=1;l<=n;l++) {
				answer += arr[l];
			}
			
			System.out.println(answer);
		}

	}
	
	public static int[] array(int[] beforeArr, int n) {
		int[] newArr = new int[n+1];
		for(int i=1;i<=n;i++) {
			newArr[i] = beforeArr[i];
		}
		for(int j=2;j<=n;j++) {
			for(int l=1;l<=j-1;l++) {
				newArr[j] += beforeArr[l];
			}
		}
		
		return newArr;
	}

}
