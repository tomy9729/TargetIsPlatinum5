//2841번 외계인의 기타 연주.java
package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 외계인의_기타_연주_2841 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static class guitar{
    	int line;
    	int num;
    	guitar(int line, int num){
    		this.line=line;
    		this.num=num;
    	}
    }
    static class s{
    	Stack<guitar> g = new Stack<guitar>();
    }
    public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		s[] g = new s[N+1];
		for(int i=1;i<=N;i++) {
			g[i] = new s();
		}
		int count=0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int line = Integer.parseInt(st.nextToken());
	    	int num = Integer.parseInt(st.nextToken());
	    	guitar now = new guitar(line, num);
	    	if(g[line].g.isEmpty()) {
	    		g[line].g.add(now);
	    		count++;
	    	}
	    	else if(g[line].g.peek().num<now.num) {
	    		g[line].g.add(now);
	    		count++;
	    	}
	    	else {
	    		while(!g[line].g.isEmpty()&&g[line].g.peek().num>now.num) {
	    			g[line].g.pop();
	    			count++;
	    		}
	    		if(!g[line].g.isEmpty()&&g[line].g.peek().num<now.num) {
	    			g[line].g.add(now);
	    			count++;
	    		}
	    		else if(g[line].g.isEmpty()){
	    			g[line].g.add(now);
	    			count++;
	    		}
	    	}
		}
		System.out.println(count);
	}
}
