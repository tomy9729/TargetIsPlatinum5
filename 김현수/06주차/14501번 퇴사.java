//14501번 퇴사.java
package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
    static int dp[];
    public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		T = new int[N+2];
		P = new int[N+2];
		dp = new int[N+2]; //마지막날까지 포함하여 상담이 가능한 경우를 위해 N+1은 0으로 둔다.
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		answer = 0;
		//p=0;
		//plan(1);
		//System.out.println(answer);
		
		for(int i=N;i>0;i--) {
			plandp(i);
		}
		System.out.println(dp[1]);
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
    
    public static void plandp(int day) {
    	if(day+T[day]-1 > N) { //현재 상담의 기간이 퇴사일을 넘어가면
    		if(day+1<=N) {
    			dp[day]=dp[day+1]; //다음날이 존재하면 다음날로 초기화
    		}
    		return;
    	}
    	if(day==N) { //마지막날이라면, 위에 안걸리므로 무조건 T[N]=1
    		dp[day]=P[day];
    		return;
    	}
    	if(day+T[day]-1<=N) {//상담이 가능하다면
    		dp[day] = Math.max(dp[day+1],P[day]+dp[day+T[day]]);//현재 상담을 하는 것  vs 현재 상담을 하지 않는 것 중 최댓값
    	}
		
    }
}
