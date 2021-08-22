//14501번 퇴사.java
package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사_14501 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int N;
    static int[] T;
    static int[] P;
    static int answer;
    static int p;
    public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		T = new int[N+1];
		P = new int[N+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		answer = 0;
		p=0;
		plan(1);
		System.out.println(answer);
	}
    
    public static void plan(int day) {
    	if(day==N+1) { //날짜 넘기면 종료
    		answer = Math.max(answer, p);//현재 금액과 최댓값 중 더 큰값으로 최댓값 갱신
    		return;
    	}
    	for(int i=day;i<=N;i++) { //지금 날짜부터 마지막 날까지
    		if(i+T[i]-1<=N) { //상담이 가능하면 상담 수행
    			p+=P[i];
    			plan(i+T[i]);
    			p-=P[i];
    		}
    		if(i<=N)plan(i+1);//상담을 하지 않는 경우
    	}
    }
}
