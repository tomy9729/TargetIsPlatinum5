package week8.day0830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2477 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int size;
	static int[] info;
	static int W,H;//긴 변
	static int w,h;//버려지는 변
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		size = Integer.parseInt(br.readLine());
		info = new int[6];
		for(int i=0; i<6; i++) {
			st = new StringTokenizer(br.readLine()," ");
			st.nextToken();//방향은 사실상 무의미하다.
			info[i] = Integer.parseInt(st.nextToken());			
		}
		//풀이 방법 2로 나누었을 때 나머지가 0이 되는 부분을 가로, 0이 아닌 부분을 세로 => 어차피 가로 세로를 반복하면서 나오기 때문에.
		for(int i=0; i<6; i++) {
			if(i%2==0) {
				W = Math.max(W, info[i]);//가로 중에서 가장 긴 변이 큰 사각형의 가로 길이가 될 것
			}else {
				H = Math.max(H, info[i]);//세로 중에서 가장 긴 변이 큰 사각형의 세로 길이가 될 것
			}
		}
		
		for(int i=0; i<6; i++) {
			if(i%2==0) {
				if(H==info[(i+5)%6]+info[(i+1)%6]) {
					w = info[i];
					//어떤 한 변의 길이를 기준으로 앞 뒤에 나온 변의 합이 큰 사각형의 세로와 같다면, 지금 위치는 꺾인 부분(버려질 사각형)의 가로와 같다.
				}
			}else {
				if(W==info[(i+5)%6]+info[(i+1)%6]) {
					h = info[i];
					//어떤 한 변의 길이를 기준으로 앞 뒤에 나온 변의 합이 큰 사각형의 가로와 같다면, 지금 위치는 꺾인 부분(버려질 사각형)의 세로와 같다.
				}
				
			}
		}
		
		int potato = (W*H-w*h)*size;
		System.out.println(potato);
	}
	
}
