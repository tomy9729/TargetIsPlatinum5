package week4.day0802;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_16505 {
	public static int N;
	public static int POW=1;
	public static char[][] star;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
		N = Integer.parseInt(st.nextToken());
//		POW = (int)Math.pow(2, N);//2^N
		//효율이 안 좋다고 한다... 
		if(N==0) {
			POW=1;
		}else {
			for(int i=0; i<N; i++) {
				POW*=2;
			}
		}
		star = new char[POW][POW];
//		System.out.println(POW);
		store(0,0,POW);
		for(int i=0; i<POW; i++) {
			for(int j=0; j<POW; j++){
				if(j==POW-i) {
					break;
				}
				if(star[i][j]=='*') {
//					System.out.printf("%c",star[i][j]);
					bw.write(star[i][j]);
				}else {
//					System.out.printf(" ");
					bw.write(" ");
				}
			}
//			System.out.println();
			bw.write("\n");
			//BufferedWriter는 flush를 할 때 전체 출력을 한다.
			//따라서 개행 문자가 쓰인다면 bw에 write해주어야 한다.
			
		}
	
		bw.flush();
		bw.close();
		
		
	}
	public static void store(int x, int y, int p) {
		if(p==1) {
			star[x][y] = '*';
			return;
		}
		
		store(x,y,p/2);
		store(x+(p/2),y,p/2);
		store(x,y+(p/2),p/2);
		
	}
}
