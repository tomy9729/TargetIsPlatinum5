package week7.day0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2527 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		
		for(int i=0; i<4; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int Ax1 = Integer.parseInt(st.nextToken());
			int Ay1 = Integer.parseInt(st.nextToken());
			int Ax2 = Integer.parseInt(st.nextToken());
			int Ay2 = Integer.parseInt(st.nextToken());
			int Bx1 = Integer.parseInt(st.nextToken());
			int By1 = Integer.parseInt(st.nextToken());
			int Bx2 = Integer.parseInt(st.nextToken());
			int By2 = Integer.parseInt(st.nextToken());
			
			
			if((Ax1==Bx2 && Ay2== By1)||(Ax1==Bx2&&Ay1==By2)||(Ax2==Bx1 && Ay2==By1)||(Ax2==Bx1 && Ay1==By2)) {
				sb.append("c\n");
			}
			else if((Ax1==Bx2 && Ay2 != By1)||(Ax1!=Bx2&&Ay1==By2)||(Ax2==Bx1 && Ay2!=By1)||(Ax2!=Bx1 && Ay1==By2)) {
				sb.append("b\n");
			}
			else if((Ax2<Bx1)||(Bx2<Ax1)||(Ay2<By1)||(By2<Ay1)) {
				sb.append("d\n");
			}
			else {
				sb.append("a\n");
			}
			
		}
		System.out.println(sb.toString());
	}

}
