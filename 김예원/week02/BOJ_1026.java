package algol;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Treasure_1026 {

	public static void main(String[] args) {
		
		/*
		  버퍼 이용하는 방법  
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		Integer[] B = new Integer[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}*/
		
		
		Scanner sc = new Scanner(System.in);
		
		int vol = sc.nextInt();
		sc.nextLine();
		
		int[] A = new int[vol];
		Integer[] B = new Integer[vol];
		int answer = 0;
		int max = -1;
		int min = 100;
		
		for(int i=0;i<vol;i++) {
			A[i] = sc.nextInt();
		}
		sc.nextLine();
		
		for(int i=0;i<vol;i++) {
			B[i] = sc.nextInt();
		}
		
		
		Arrays.sort(A);
		Arrays.sort(B, Collections.reverseOrder());
		for(int i=0;i<vol;i++) {
			answer += A[i] * B[i];
		}
		System.out.println(answer);
		
	}

}
