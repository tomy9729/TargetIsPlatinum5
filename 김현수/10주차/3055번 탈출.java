//3055번 탈출.java
package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 탈출_3055 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int answer=-1;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		point start = new point(-1,-1);
		List<point> water = new ArrayList<point>();
		int[][] visit = new int[R][C];
		for(int i=0;i<R;i++) {
			String temp = br.readLine();
			for(int j=0;j<C;j++) {
				map[i][j] = temp.charAt(j);
				if(map[i][j]=='S') {
					start = new point(i,j);
					map[i][j]='.';
				}
				else if(map[i][j]=='*') {
					water.add(new point(i,j));
				}
			}
		}
		
		bfs(map, start, water, visit, R, C);
		
		if(answer==-1)System.out.println("KAKTUS");
		else System.out.println(answer);
	}
	static void bfs(char[][] map, point start, List<point> water, int[][] visit, int R, int C) {
		int[] di = {0,0,1,-1};
		int[] dj = {1,-1,0,0};
		Queue<point> qWater = new LinkedList<point>();
		Queue<point> qBeaver = new LinkedList<point>();
		for(int i=0;i<water.size();i++)qWater.add(water.get(i));
		qBeaver.add(start);
		while(!qWater.isEmpty()) {
			point nowWater = qWater.poll();
			if(nowWater.i==-1)break;
			for(int d=0;d<4;d++) {
				int nextI = nowWater.i+di[d];
				int nextJ = nowWater.j+dj[d];
				if(0<=nextI && nextI<R && 0<=nextJ && nextJ<C) {
					if((map[nextI][nextJ]=='S' || map[nextI][nextJ]=='.')&& visit[nextI][nextJ]==0) {
						visit[nextI][nextJ]=visit[nowWater.i][nowWater.j]-1;
						qWater.add(new point(nextI,nextJ));
					}
				}
			}
		}
		visit[start.i][start.j]=0;
		while(!qBeaver.isEmpty()) {
			point nowBeaver = qBeaver.poll();
			for(int d=0;d<4;d++) {
				int nextI = nowBeaver.i+di[d];
				int nextJ = nowBeaver.j+dj[d];
				if(0<=nextI && nextI<R && 0<=nextJ && nextJ<C) {
					if(map[nextI][nextJ]!='X' && (visit[nextI][nextJ]*(-1)>visit[nowBeaver.i][nowBeaver.j]+1 || visit[nextI][nextJ]==0)) {
						visit[nextI][nextJ]=visit[nowBeaver.i][nowBeaver.j]+1;
						qBeaver.add(new point(nextI,nextJ));
					}
					if(map[nextI][nextJ]=='D') {
						answer=visit[nowBeaver.i][nowBeaver.j]+1;
						return;
					}
				}
			}
		}
	}
	static class point{
		int i;
		int j;
		point(int i, int j){
			this.i=i;
			this.j=j;
		}
	}
}
