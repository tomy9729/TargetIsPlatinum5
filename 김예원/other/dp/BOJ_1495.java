package week06.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1495 {

	static int N, S, M, max=-1, c = 0;
	static int[] arr;
	static boolean flag = true;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken()); 
		}
		
		
		dfs(0,0);
		
		if(c!=N) System.out.println(-1);
		else 
			System.out.println(max);
		
	}
	
	private static void dfs(int cnt , int start) {
		
		if(cnt==N) {
			
			if(max<S) max = S;
			c = N;
			return;
		}
		
		int d = arr[start];
		int s = S+d;
		cnt+=1;
		
		if(isIn(s)) {
			S+=d;
			dfs(cnt,start+1);
			S-=d;
		}
		
		s = S-d;
		if(isIn(s)) {
			S-=d;
			dfs(cnt,start+1);
			S+=d;
		}
		
		// 둘 다 안된다면
		if(c!=N)
			c = cnt;
		
		return;
		
	}
	private static boolean isIn(int n) {
		return n>=0 && n<=M;
	}

}
