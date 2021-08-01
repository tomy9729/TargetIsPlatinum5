package week3.day0728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2869 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
		int up = Integer.parseInt(st.nextToken());
		int down = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());
		
		/*double cnt = (1.0*(target-down)) / (up-down);//내려갈 걸 미리 계산한 걸 목표로 생각해봄.
		if(cnt%1 <0.5) {
			cnt++;
			//5 1 6처리가 안 되네..
			//5 1 6에서는 cnt가 5/4로 1.25가 됨...
			//비슷한 예시로 8 3 9도 안 되는듯
			
		}*/
		int cnt = (target-down)/(up-down);
		//예제 5 1 6 모자람 1
		//3 1 8 모자람 / 8 3 9 1일 모자람
		//-> 그럼 2 1 5랑 100 99 1000000000는 왜 되는겨
		//=> 한칸씩 움직이는 거나 다름 없지만, 마지막 움직이는 건 up만큼 움직였을 때 정상도착을 함.
		// ==> 999999900번째 까지 1칸씩 움직이다가 100만큼 올라가서 내려갈 핋요 없이 끝남.
		if((target-down)%(up-down) !=0) {
			cnt++;
		}//(target-down)을 (up-down)으로 나누었을 때 나머지가 0이 아니라면, 한 번 더 올라가야 된다!
		System.out.printf("%d",(int)cnt);
	}

}
