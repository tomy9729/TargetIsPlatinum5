//3190번 뱀.java
package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 뱀_3190 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static class dir{
    	int X;
    	String C;
    	dir(int X, String C){
    		this.X = X;
    		this.C = C;
    	}
    }
    static class point{
    	int i;
    	int j;
    	point(int i, int j){
    		this.i = i;
    		this.j = j; 
    	}
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
		int N =Integer.parseInt(br.readLine());
		int K =Integer.parseInt(br.readLine());
		int[][] map = new int[101][101];
		
		map[1][1]=2;//뱀
		for(int apple=0;apple<K;apple++) {
			st = new StringTokenizer(br.readLine()," ");
			int i=Integer.parseInt(st.nextToken());
			int j=Integer.parseInt(st.nextToken());
			map[i][j]=1;//사과
		}
		
		int L =Integer.parseInt(br.readLine());
		Queue<dir> d = new LinkedList<>();
		for(int i=0;i<L;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int X = Integer.parseInt(st.nextToken());
			String C = st.nextToken();
			d.add(new dir(X,C));
		}
		
		Deque<point> snake = new LinkedList<>();
		snake.addLast(new point(1,1));
		
		int[] dI = {0,1,0,-1};
		int[] dJ = {1,0,-1,0};
		
		int time=0;
		int dir=0;
		while(true) {
			time++;
			point s = snake.getLast();//현재 뱀의 머리 위치
			int snakeI = s.i+dI[dir%4];//뱀의 머리가 이동할 위치
			int snakeJ = s.j+dJ[dir%4];
			if(1<=snakeI && snakeI<=N && 1<=snakeJ && snakeJ <=N) {
				if(map[snakeI][snakeJ]==2)break;//자기자신과 부딪혀서 끝
				
				if(map[snakeI][snakeJ]==0) {//사과가 없는 경우
					point nail = snake.removeFirst();//꼬리 삭제
					map[nail.i][nail.j]=0;
				}//사과가 있으면 꼬리 그대로 
				
				snake.addLast(new point(snakeI,snakeJ));
				map[snakeI][snakeJ]=2; //뱀 머리 표시
			}
			else break; //벽에 부딪혀서 끝
			
			//방향 전환
			if(!d.isEmpty() && d.peek().X==time) {
				dir changeD = d.poll();
				if(changeD.C.equals("L")) dir += 3;
				else dir += 1;
			}
		}
		System.out.println(time);
	}
}
