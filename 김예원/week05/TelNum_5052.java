package algol.notSolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;


public class TelNum_5052 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		
		for(int i=0;i<N;i++) {
			int M = Integer.parseInt(br.readLine());
			String[] arr = new String[M];
			for(int j=0;j<M;j++) {
				arr[j] = br.readLine();
			}
			//Arrays.sort(arr,(o1,o2)->{return Integer.compare(o1.length(), o2.length());});
			
			// 포인트1. 정렬 
			Arrays.sort(arr);
			Arrays.stream(arr).forEach(s ->{System.out.println(s);});
			
			boolean boo = true;
			for(int j=0;j<M-1;j++) {
				// 포인트2 .startsWith()
				if(arr[j+1].startsWith(arr[j])){
					boo = false;
					break;
				}
			}
			
			if(boo)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

}
