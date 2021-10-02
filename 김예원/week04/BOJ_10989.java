package algol.notSolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sort3_10989 {
	public static void main(String[] args) throws IOException {
		// **카운팅정렬
		// 입력될 수 있는 값의 최대 범위까지 배열을 만들어주고, 입력된 값을 인덱스로 하는 배열 요소에 1을 더해준다
		// 시간복잡도는 O(N+k) 즉, O(N)과 같다
		// Arrays.sort() 의 경우 평균O(nlogn)에서 O(n2)까지 나올 수 있다.
		
        // 수의 범위 (0 ~ 10000) 사실상 0은 제외
        int[] cnt = new int[10001];
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int N = Integer.parseInt(br.readLine());
 
        for (int i = 0; i < N; i++) {
            // 해당 인덱스의 값을 1 증가
            cnt[Integer.parseInt(br.readLine())] ++;
        }
 
        br.close();
 
        StringBuilder sb = new StringBuilder();
 
        // 0은 입력범위에서 없으므로 1부터 시작
        for(int i = 1; i < 10001; i++){
            // i 값이 개수가 0 이 될 때 까지 출력 (빈도수를 의미)
            while(cnt[i] > 0){
                sb.append(i).append('\n');
                cnt[i]--;
            }
        }
        System.out.println(sb);
    }
	

}
