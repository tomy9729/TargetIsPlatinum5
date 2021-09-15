package dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class swea_7465{
    static int[] numbers, rank;
    static int answer;
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
         
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
             
             
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            answer = n;
            init(n);
             
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
 
                union(a, b);
            }
            sb.append('#').append(t).append(" ").append(answer).append('\n');
        }
        System.out.println(sb);
         
    }
     
    public static void init(int n) {
        numbers = new int[n+1];
        rank = new int[n+1];
         
        for (int i = 1; i <= n; i++) {
            numbers[i] = i;
            rank[i] = 0;
        }
    }
     
    public static int find(int num) {
        if (numbers[num] == num)
            return num;
         
        return numbers[num] = find(numbers[num]);
    }
     
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
         
        if (a==b)
            return;
         
        if (rank[a] > rank[b]) numbers[b] = a;
        else numbers[a] = b;
         
        if (rank[a] == rank[b])
            rank[b]++;
         
        answer--;
    }
}