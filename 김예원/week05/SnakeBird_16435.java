package algol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SnakeBird_16435 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int foodN = Integer.parseInt(st.nextToken());
		int sbLong = Integer.parseInt(st.nextToken());
		int[] food  = new int[foodN];
		
		st = new StringTokenizer(br.readLine());

		// 먹이 배열 초기화 
		for(int i=0;i<foodN;i++) {
			food[i] = Integer.parseInt(st.nextToken());
		}
		
		// 먹이 정렬
		Arrays.sort(food);
		
		
		// 먹이가 스네이크버드보다 작을 때에만 먹기
		for(int i=0;i<foodN;i++) {
			if(sbLong>=food[i])
				sbLong++;
		}
		
		System.out.println(sbLong);
	}

}
