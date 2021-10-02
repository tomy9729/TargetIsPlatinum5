//1504번 특정한 최단 경로.java
package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 특정한_최단_경로_1504 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static class edge{
    	int dest;
    	int distance;
    	edge(int dest, int distance){
    		this.dest = dest;
    		this.distance = distance;
    	}
    }
    static class pre implements Comparable<pre>{
    	int distance;
    	int start;
    	boolean[] point = new boolean[N+1];
    	pre(int distance, int start) {
    		this.distance = distance;
    		this.start = start;
    	}
    	
    	
    	@Override
    	public int compareTo(pre o) {
    		return Integer.compare(this.distance, o.distance);
    	}
    }
    static int N;
    static ArrayList<ArrayList<edge>> Graph;
    static int[] v ;
    public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		Graph = new ArrayList<ArrayList<edge>>();
		for(int i=0;i<=N;i++) {
			Graph.add(new ArrayList<edge>());
		}
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			Graph.get(a).add(new edge(b,c));
			Graph.get(b).add(new edge(a,c));
		}
		v = new int[2];
		st = new StringTokenizer(br.readLine()," ");
		v[0] = Integer.parseInt(st.nextToken());
		v[1] = Integer.parseInt(st.nextToken());
		int result1 = dijkstra(1,v[0]) + dijkstra(v[0],v[1]) + dijkstra(v[1],N);
		int result2 = dijkstra(1,v[1]) + dijkstra(v[1],v[0]) + dijkstra(v[0],N);
		int answer = Math.min(result1, result2);
		if(answer<0 || answer == 2147483645)answer=-1;
		System.out.println(answer);
		
	}
    public static int dijkstra(int start, int dest) {
    	int[] root = new int[N+1];
    	Arrays.fill(root, Integer.MAX_VALUE);
    	root[start] = 0;
    	PriorityQueue<pre> minHeap = new PriorityQueue<>();
    	minHeap.add(new pre(0,start));
    	
    	while(!minHeap.isEmpty()) {
    		pre now = minHeap.poll();
    		if(root[now.start] < now.distance)continue;
    		
    		for(edge next : Graph.get(now.start)) {
    			int nextCost = now.distance+next.distance;
    			if(nextCost < root[next.dest]) {
    				root[next.dest] = nextCost;
    				minHeap.add(new pre(nextCost, next.dest));
    			}
    		}
    	}
    	return root[dest];
    }
}
