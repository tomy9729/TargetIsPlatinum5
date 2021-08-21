//7568번 덩치.java
package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class 덩치_7568 {
	private static List<people> p = new ArrayList<>();
	private static int n;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			String line = br.readLine();
			StringTokenizer st = new StringTokenizer(line," ");
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			people pp = new people(h, w);
			p.add(pp);
		}
		
		for(int i=0;i<n;i++) {
			int r = 0;
			for(int j=0;j<n;j++) {
				if(p.get(i).getWeight() < p.get(j).getWeight() && p.get(i).getHeight() < p.get(j).getHeight()) {
					r++;
				}
			}
			p.get(i).setRank(r+1);
			sb.append(p.get(i).getRank()).append(" ");
		}
		System.out.println(sb.toString());
		
	}
	
	public static class people{
		private int height;
		private int weight;
		private int rank;
		public int getRank() {
			return rank;
		}
		public void setRank(int rank) {
			this.rank = rank;
		}
		people(int h, int w){
			this.height = h;
			this.weight = w;
		}
		public int getHeight() {
			return height;
		}
		public void setHeight(int height) {
			this.height = height;
		}
		public int getWeight() {
			return weight;
		}
		public void setWeight(int weight) {
			this.weight = weight;
		}
	}
}
