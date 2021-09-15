package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2636 {
	static int N,M;
    static int map[][];
    static int cheeseCnt;
    static int dx[] = {0,0,-1,1};
    static int dy[] = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
        int time = 0;
        //1.치즈가 다 녹았는지 안녹았는지
        while(!isFind()){
//            for(int i=0;i<N;i++) System.out.println(Arrays.toString(map[i]));
//            System.out.println("====================");
            //2.공기 check
            findAir();
            //3.녹을 치즈 선정
            cheese();
            time++;
        }

        System.out.println(time);
        System.out.println(cheeseCnt);

    }

    private static void cheese() {
        //bfs로 사방탐색하면서 주변이 2와 맞닿은 곳이 있으면 녹을 치즈로 선정해주기

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] == 1){
                    bfs(i,j);
                }
            }
        }
        int cnt = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] == 3) {
                    map[i][j] = 2;
                    cnt++;
                }
            }
        }
        cheeseCnt = cnt;

    }

    private static void bfs(int row, int col) {

        for(int d=0;d<4;d++){
            int nx = row + dx[d];
            int ny = col + dy[d];

            if(nx<0 || ny<0 || nx>=N || ny>=M) continue;

            if(map[nx][ny] == 2){
                map[row][col] = 3; //녹을 치즈는 3으로 표시
                break;
            }
        }
    }

    private static void findAir() {
        //0,0부터 bfs로 사방탐색하면서 공기 check하기
        //공기는 2로 check하기
        boolean isVisited[][] = new boolean[N][M];
        Queue<int []> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        isVisited[0][0] = true;
        
        while(!q.isEmpty()){
            int node[] = q.poll();
            
            for(int d=0;d<4;d++){
                int nx = node[0] + dx[d];
                int ny = node[1] + dy[d];

                if(nx<0 || ny<0 || nx>=N || ny>=M || isVisited[nx][ny] || map[nx][ny] == 1) continue;

                q.offer(new int[]{nx,ny});
                map[nx][ny] = 2;
                isVisited[nx][ny] = true;
            }
        }
    }

    private static boolean isFind() {
        int cnt = 0;

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j] == 1){
                    cnt++;
                    break;
                }
            }
        }

        return (cnt==0)?true:false;
    }

}
