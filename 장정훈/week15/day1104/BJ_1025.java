package week16.day1104;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1025 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			char[] arr = br.readLine().toCharArray();
			for(int j=0; j<M; j++) {
				map[i][j] = arr[j]-'0';
			}
		}
		double result = -1;
		for(int n=0; n<N; n++) {
			for(int m=0; m<M; m++) {
				
				for(int nn=(N*-1); nn<N; nn++) {
					
					for(int mm=(M*-1); mm<M; mm++) {
						
						if(nn ==0 && mm ==0) continue;
						
						String num = "";
						int mul = 0;
						int r=n;
						int c=m;
						
						while(isIn(r,c)) {
							
							num += map[r][c];
							mul += 1;
							//Math.sqrt를 하면 double이 나오니깐 다시 제곱한 숫자랑 뺐을 때 0이거나 더 클 때
							double val = Math.sqrt(Double.parseDouble(num));
							long pow = (long) Math.pow(val, 2);
							if(val-pow == 0 && val>result) {
								result = val;
								r = n+ (mul*nn);
								c = m+ (mul*mm);
							}
							
							
						}
						System.out.println(r+"-------------"+c);
					}
					
					
				}
				
		
			}
		}
		System.out.println(result);
	}

	private static boolean isIn(int r, int c) {
		return 0<=r && r<N && 0<=c && c<M;
	}
}
