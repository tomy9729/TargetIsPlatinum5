package week4.day0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BJ_5568 {
	public static Set<String> set;//중복 안 들어가니깐 다 넣고 사이즈 측정.
	public static String[] ary;
	public static boolean[] selected;
	public static int N;//nPr 에서 n
	public static int R;//nPr 에서 r
	public static int C;//Case
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		R = Integer.parseInt(br.readLine());
		ary = new String[N];
		selected = new boolean[N];
		
		for(int n=0; n<N; n++) {
			ary[n] = br.readLine();
		}
		set = new HashSet<>();
//		for(int i=0; i<N; i++) {
//			C=i;
//			selected[i] = true;
//			makeCase("",i,1);
//			selected[i] = false;
//		}
		makeCase("", 0, 0);
		System.out.println(set.size());
	}
	private static void makeCase(String str,int n,int r) {
		if(r==R) {
			set.add(str);
			return;
		}

		for(int i=0; i<N; i++) {
			String s = "";
			if(selected[i]) {
				continue;
			}
			s = str+ary[i];
			selected[i] = true;
			makeCase(s,i, r+1);
			selected[i] = false;
		}
		
	}
	

}
