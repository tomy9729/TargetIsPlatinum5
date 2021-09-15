//1495번 기타리스트.java
package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기타리스트_1495 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int S;
    static int M;
    static int[]v;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
    	st = new StringTokenizer(br.readLine()," ");
    	N = Integer.parseInt(st.nextToken());//곡의개수
    	S = Integer.parseInt(st.nextToken());//시작볼륨
    	M = Integer.parseInt(st.nextToken());//볼륨은 M이하
    	
    	st = new StringTokenizer(br.readLine()," ");
    	v = new int[N+1];
    	for(int i=1;i<=N;i++)v[i]=Integer.parseInt(st.nextToken());
    	
    	dp = new int[N+1][M+1];
    	nextVolume(1,S);
    	
    	boolean check=true;
    	for(int i=M;i>=0;i--) {
    		if(dp[N][i]==1) {
    			System.out.println(i);
    			check=false;
    			break;
    		}
    	}
    	if(check)System.out.println(-1);
    	
	}
    public static void nextVolume(int i,int vol) {
    	if(i==N+1)return;
    	if(vol+v[i]<=M) {
    		if(dp[i][vol+v[i]]==0){
    			dp[i][vol+v[i]]=1;
        		nextVolume(i+1,vol+v[i]);
    		}
    		
    	}
    	if(vol-v[i]>=0) {
    		if(dp[i][vol-v[i]]==0){
    			dp[i][vol-v[i]]=1;
        		nextVolume(i+1,vol-v[i]);
    		}
    	}
    }
}
