package algol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class aliquot_2501 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String string = br.readLine();
        String[] stringArr = string.split(" ");
        
        int N = Integer.parseInt(stringArr[0]);
        int K = Integer.parseInt(stringArr[1]);
        List<Integer> arr = new ArrayList<>();
        /*for(int i=0;i<N;i++)
        	arr.add(i);*/
        

    	for(int i=N;i>0;i--) {
    		if(N%i==0) {
    			arr.add(i);
    		}
    	}
        Collections.sort(arr);
    	
    	// 출력
        if(arr.size()<K)
        	 bw.write("0");       	
        else
        	bw.write(arr.get(K-1) + "\n");       	  
       
      
		bw.flush();
        bw.close();
	}

}
