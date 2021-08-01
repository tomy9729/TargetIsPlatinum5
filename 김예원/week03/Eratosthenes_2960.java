package algol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Eratosthenes_2960  {

	public static void main (String[] args) throws IOException {
		

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = br.readLine().split(" ");
        int N = Integer.parseInt(nk[0]);
        int c = Integer.parseInt(nk[1]);
		
        
        int[] arr = new int[N+2];
        for(int i=2;i<=N;i++) {
			arr[i]=i;
		}
        
		
		int index = 2;
		int now = 0;
		int count =0;
		
		outer : for(int i=2;i<=N;i++) {
			if(arr[i]==0) {
				//System.out.println(i+"번째  F");
				continue outer;
			}
			
			for(int j=2; j<i; j++){
				if(arr[i] % j == 0) {
					
					continue outer;
				}
			}
			
			int mul = i;
			//now = arr[i];
			
			
			count++;
			index = i;
			if(count==c) {
				
				break outer;
			}
			arr[i] = 0;
			
			wh : while((i+mul)<=N) {
				if(arr[i+mul]==0) {
					mul+=i;
					continue wh;
				}
				
				index = i+mul;
				count ++;
				if(count==c) {
					
					break outer;
				}
				arr[i+mul] = 0;
				mul+=i;
			}
		}
		bw.write(index + "\n");
		//System.out.println();
		
		bw.flush();
        bw.close();
	}

}
