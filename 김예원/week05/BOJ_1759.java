package classAlgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1759 {

	static int L,C;
	static char[] arr;
	static char[] selected;
	static List<String> result = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		String s = br.readLine(); 
		arr = new char[C];
		//char[] selected = new boolean[C];
		int index = 0;
		for(int i=0;i<(C+C-1);i++) {
			arr[index++] = s.charAt(i);
			i++;
		}
		//System.out.println(Arrays.toString(arr));
		
		// L개 뽑기
		selected = new char[L];
		com(0,0);
		
		Collections.sort(result);
		
		StringBuilder sb = new StringBuilder();
		for(String a : result) {
			sb.append(a).append("\n");
		}
		System.out.println(sb.toString());
		
	}
	private static void com(int cnt, int start)  {

		if(cnt==L) {
			
			int v = 0;
			int c = 0;
			for(int i=0;i<L;i++) {
				if("aeiou".indexOf(selected[i])!=-1) v++;
				else c++;
				
				if(v>=1 && c>=2) {
					String s = String.valueOf(selected);
					char[] ch = s.toCharArray();
					Arrays.sort(ch);
					s = String.valueOf(ch);
					result.add(s);
					break;
				}
			}

			return;
		}
		
		
		for(int i=start;i<C;i++) {
			selected[cnt]=arr[i];
			com(cnt+1,i+1);

		}
		
	}

}
