//1197번 최소 스패닝 트리.java
package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최소_스패닝_트리_1197 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		List<ArrayList<edge>> graph = new ArrayList<>();
		for(int i=0;i<=V;i++) {
			graph.add(new ArrayList<edge>());
		}
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			graph.get(a).add(new edge(b, c));
			graph.get(b).add(new edge(a, c));
		}
		
		System.out.println(prim(V, graph));
		
	}
    
    public static long prim(int V, List<ArrayList<edge>> graph) {
    	boolean[] visited = new boolean[V + 1];
    	PriorityQueue<edge> pq = new PriorityQueue<>();
    	
    	pq.add(new edge(1, 0));
    	
    	long res = 0;
    	int cnt = 0;
    	while(!pq.isEmpty()) {
    		edge e = pq.poll();
    		if(visited[e.end])continue;
    		
    		res += e.val;
    		visited[e.end] = true;
    		if(++cnt==V)return res;
    		
    		for(int i=0;i<graph.get(e.end).size();i++) {
    			edge next = graph.get(e.end).get(i);
    			if(visited[next.end])continue;
    			
    			pq.add(next);
    		}
    	}
    	
    	return res;
    }
    static class edge implements Comparable<edge>{
    	int end;
    	int val;
    	edge(int end, int val){
    		this.end = end;
    		this.val = val;
    	}
    	
    	@Override
    	public int compareTo(edge o) {
    		return Integer.compare(this.val, o.val);
    	}
    }
}
