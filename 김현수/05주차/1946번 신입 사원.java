//1946번 신입 사원.java
package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 신입_사원_1946 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static class person implements Comparable<person>{
    	int rank1;
    	int rank2;
    	person(int rank1, int rank2){
    		this.rank1 = rank1;
    		this.rank2 = rank2;
    	}
    	@Override
		public int compareTo(person o) {
			int value = this.rank1 - o.rank1;
			return value*-1;
		}
		@Override
		public String toString() {
			return "person [rank1=" + rank1 + ", rank2=" + rank2 + "]";
		}
    	
    }
    static int T;
    static int N;
    static person[] people;
    static int answer;
    public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			N = Integer.parseInt(br.readLine());
			people = new person[N];
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine()," ");
				people[i]=new person(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			}
			
			Arrays.sort(people);
			
			answer=N;
			int minR = Integer.MAX_VALUE;
			for(int i=N-1;i>=0;i--) {
				if(people[i].rank2 < minR) minR=people[i].rank2;
				else answer--;
			}
			sb.append(answer+"\n");
		}
		System.out.println(sb.toString());
	}
}
