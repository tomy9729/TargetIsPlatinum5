//2170번 선 긋기.java
package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class paper{
	public int x;
	public int y;
	paper(int x, int y){
		this.x=x;
		this.y=y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
}
public class 선_긋기_2170 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int N;
    static List<paper> p = new ArrayList<paper>();
    static int answer=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			p.add(new paper(x,y));
		}
		
		p.sort(new Comparator<paper>() {
			@Override
			public int compare(paper o1, paper o2) {
				return Integer.compare(o1.getX(), o2.getX());
			}
		});
		
		int x = p.get(0).x;
		int y = p.get(0).y;
		
		for(int i=1;i<p.size();i++) {
			if(p.get(i).x <= y) {
				y = Math.max(y, p.get(i).y);
			}
			else {
				answer += y-x;
				x = p.get(i).x;
				y = p.get(i).y;
			}
		}
		answer += y-x;
		
		System.out.println(answer);
	}
}
