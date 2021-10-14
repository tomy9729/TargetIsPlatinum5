//2573번 빙산.java
package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 빙산_2573 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<M;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer=0;				
		while(true) {
			if(getLumpCnt(arr)>=2) {
				break;
			}
			else if(getLumpCnt(arr)==0) {
				answer=0;
				break;
			}
			meltIceberg(arr);
			answer++;
		}
		
		System.out.println(answer);
	}
	
	public static void meltIceberg(int[][] arr) {
		int[] di = {0,0,1,-1};
		int[] dj = {1,-1,0,0};
		int N = arr.length;
		int M = arr[0].length;
		int[][] melt = new int[N][M];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j]>0) {
					int cnt=0;
					for(int d=0;d<4;d++) {
						int nextI = i+di[d];
						int nextJ = j+dj[d];
						if(0<=nextI&&nextI<N&&0<=nextJ&&nextJ<M) {
							if(arr[nextI][nextJ]<=0) {
								cnt++;
							}
						}
					}
					melt[i][j]=cnt;
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				arr[i][j] -= melt[i][j];
			}
		}
	}
	public static int getLumpCnt(int[][] arr) {
		int N = arr.length;
		int M = arr[0].length;
		boolean[][] visit = new boolean[N][M];
		int cnt = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(!visit[i][j] && arr[i][j]>0) {
					cnt++;
					bfs(visit,arr,i,j);
				}
			}
		}
		return cnt;
	}
	private static void bfs(boolean[][] visit, int[][] arr, int i, int j) {
		int[] di = {0,0,1,-1};
		int[] dj = {1,-1,0,0};
		int N = arr.length;
		int M = arr[0].length;
		Queue<point> q = new LinkedList<point>();
		q.add(new point(i,j));
		while(!q.isEmpty()) {
			point now = q.poll();
			for(int d=0;d<4;d++) {
				point next = new point(now.i+di[d],now.j+dj[d]);
				if(0<=next.i&&next.i<N&&0<=next.j&&next.j<M) {
					if(!visit[next.i][next.j] && arr[next.i][next.j] > 0) {
						visit[next.i][next.j]=true;
						q.add(next);
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
