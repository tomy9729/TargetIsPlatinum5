package week06.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
/*
 * 퇴사2
 * 동적 계획법(DP)으로 풀기
 */
public class BOJ_15486 {
 
    private static int[] T, P;
    private static int N;
    private static int max;
    private static int[] DP;
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(in.readLine());
        
        T = new int[N + 2];
        P = new int[N + 2];
        
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        
        DP = new int[N + 2]; 
       
        
        for (int i = 1; i < N + 2; i++) {
        
            
            if(max < DP[i])
                max = DP[i];
            
            int day = i + T[i];
            if(day < N + 2)
                DP[day] = Math.max(DP[day], max + P[i]);
            
        }
    
        System.out.println(max);
    }
 
}


