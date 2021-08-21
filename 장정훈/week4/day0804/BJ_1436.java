package week4.day0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1436 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int end = 666;//첫번째 종말시작.
		int cnt=1;
		while(cnt!=n) {//첫번째 영화는 보장됨.
			end++;
			//666만 포함하면 되는데 
			//귀찮아서 666부터 1씩 증가시키면서 그 숫자에 "666"이라는 문자열이 포함되어있는지 확인함.
			//cnt 최초는 1로, 입력받는 n이 자연수이기 때문에  1부터 시작하기 한다.
			//그래서 end값도 666부터 시작한다. 1을 입력받으면 반복문 거치지 않고 바로 출력.
			
			String str = end+"";//contains쓰려고 ""를 더함.
			if(str.contains("666")) {
				cnt++;
			}
		}//복잡하게 짜면 시간은 더 줄어든다는 것을 다른 사람들 코드를 보고 느낌.
		//제한시간이 2초라서 여유로움. 2억 연산 가능..
		System.out.println(end);
		
	}

}
