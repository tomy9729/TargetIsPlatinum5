package week4.day0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1120 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String strA = st.nextToken();
		String strB = st.nextToken();
		
		int ans=50;
		//최대 길이가 50이라서 50개 전부 다 다를 수도 있다.
		
		for(int i=0; i<=strB.length()-strA.length(); i++) {
			//strA와 strB의 길이가 같을 때 최소 한번은 실행 되어야 해서 <=으로 표기
			//strA와 strB의 길이 차이까지 반복 -> 
			int cnt=0;
			for(int j=0; j<strA.length(); j++) {
				//strA의 앞 혹은 뒤에 strB의 길이가 될 때까지 아무 알파벳을 넣어서 길이를 맞춰주는 시늉
				//즉, strA가 strB에 포함이 되어있으면 차이의 최소는 0이다.
				if(strA.charAt(j)!=strB.charAt(j+i)) {
					//strA의 앞쪽에 i만큼 뭔가 들어왔다 치는데 이 뭔가 들어온 건 사실 strB에서 0~i까지 똑같이 붙였다 가정.
					//문제에서 주어진 게 아무 알파벳이지만, A와 B의 차이를 최소화하는 것이기 때문에
					//strA가 strB에 최대한 많이 속하는 위치를 찾으면 그 위치에서 strA와 strB의 차이가 최소가 된다.
					cnt++;
				}
			}
			ans = Math.min(ans, cnt);//값이 가장 적을 때를 찾기 때문에..
		}
		System.out.println(ans);
		
		br.close();
	}

}
