package week6.day0820;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SWEA_1223 {

	static BufferedReader br;
	static StringBuilder sb = new StringBuilder();
	static char[] cal;
	static int N;
	static long sum;
	static Stack<Integer> num;
	static Stack<Character> cc;
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input_SWEA1223.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			N = Integer.parseInt(br.readLine());
			cal = br.readLine().toCharArray();
			sum = 0;
			num = new Stack<>();
			cc = new Stack<>();
			int i=0;
			while(i<N) {
				if(cal[i] != '+' && cal[i] != '*') {
					num.push(cal[i]-'0');
				}else if(cal[i] == '+') {
					cc.push(cal[i]);//cc크기가 4면 num크기는 5일것
				}else if(cal[i] == '*') {
					int x = num.pop();
					int s = x * (cal[i+1]-'0');
					num.push(s);
					i++;
				}
				i++;
			}
			
			sum += num.pop();
			while(!cc.isEmpty()) {
				cc.pop();
				sum += num.pop();
			}
			
			sb.append("#"+tc+" "+sum+"\n");
		}
		System.out.println(sb.toString());
	}

}
