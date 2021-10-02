package algol;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Bulk_7568_note {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer stk=null;
		int N = Integer.parseInt(br.readLine());
		
		List<List<Integer>> outer = new ArrayList<>();
		
		int count = 1;
		
		for(int i=0;i<N;i++) {
			List<Integer> inner = new ArrayList<>();
			stk =new StringTokenizer(br.readLine()," ");
			inner.add(Integer.parseInt(stk.nextToken()));
			inner.add(Integer.parseInt(stk.nextToken()));
			outer.add(inner);
		}
	
		for(int i=0;i<N;i++) {
			List<Integer> arr = new ArrayList<>();
			count = 1;
			arr = outer.get(i);
			for(int j=0;j<N;j++) {
				
				//같은 번호라면 berak;
				if(i==j)
					continue;
				
				if((arr.get(0)<outer.get(j).get(0) && arr.get(1)<outer.get(j).get(1)))
					count++;

			}
			
			//bw.write(count+" "); 왜 안됨?
			System.out.print(count+" ");
		}

	}

}
