package algol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SortWord_1181 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        
        //중복제거
        Set<String> setList = new HashSet<>();
        
        String[] arr = new String[N];
        for(int i=0;i<N;i++) {
        	setList.add(br.readLine());
        }
       
        // list로 변환
        List<String> list = new ArrayList<String>(setList);
        
        
        //1차 정렬(길이로)
        
        list.sort((s1,s2)->{
        	if(s1.length()==s2.length())
        		return s1.compareTo(s2);
        	else
        		return Integer.compare(s1.length(), s2.length());
        });
       
        
        for(int i=0;i<list.size();i++) {
        	bw.write(list.get(i) + "\n");       	  
       }
      
		bw.flush();
        bw.close();
	}

}
