package week7.day0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2810 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	
	static int cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		
		for(int i=0; i<N; i++) {
			if(str.charAt(i) == 'S') {
				cnt++;
			}else {
				cnt++;
				i++;
			}
		}//모든 좌석을 기준으로 오른쪽에 컵홀더를 사용할 수 있다.
		if(cnt<N) {
			cnt++;
		}//근데 좌석 수보다 사용할 수 있는 컵홀더의 개수가 부족하면 맨 왼쪽도 사용해야 하므로 1 증가. => 커플석이 하나라도 있으면 좌석 수가 컵홀더 개수보다 작아진다.
		System.out.println(cnt);
	}

}
