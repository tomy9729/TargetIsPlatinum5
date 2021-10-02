//1525번 퍼즐.java
package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 퍼즐_1525 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
		int[][] puzzle = new int[3][3];
		int start = 0;
		for(int i=0;i<3;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				int temp = Integer.parseInt(st.nextToken());
				if(temp==0)start = start*10+9;
				else start = start*10+temp;
			}
		}
		bfs(start, puzzle, 0);
	}
    
    static void bfs(int start,int[][] puzzle, int count) {
    	int[] di = {0,0,1,-1};
    	int[] dj = {1,-1,0,0};
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	Queue<Integer> q = new LinkedList<>();
    	
    	map.put(start, 0);
    	q.add(start);
    	
    	int nowX,nowI,nowJ;
    	int nextX,nextI,nextJ;
    	int d,c;
    	String now,next;
    	while(!q.isEmpty()) {
    		now = Integer.toString(q.poll());
    		nowX = now.indexOf('9');
    		nowI = nowX/3;
    		nowJ = nowX%3;
    		for(d=0;d<4;d++) {
    			nextI = nowI+di[d];
    			nextJ = nowJ+dj[d];
    			nextX = nextI*3+nextJ;
    			if(0<=nextI&&nextI<3&&0<=nextJ&&nextJ<3) {
    				char temp = now.charAt(nextX);
    				next = now.replace('9', 'x');
    				next = next.replace(temp, '9');
    				next = next.replace('x', temp);
    				
    				if(!map.containsKey(Integer.parseInt(next))) {
    					map.put(Integer.parseInt(next), map.get(Integer.parseInt(now))+1);
    					q.add(Integer.parseInt(next));
    				}
    				if(map.containsKey(123456789)) {
    		    		System.out.println(map.get(123456789));
    		    		return;
    		    	}
    			}
    		}
    	}
    	System.out.println(-1);
    }
}
