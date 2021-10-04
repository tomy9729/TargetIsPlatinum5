package week6.day0818;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JG_1828 {//JG는 JUNGOL 문제
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		Chemical[] chemicals = new Chemical[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			chemicals[i] = new Chemical(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		ArrayList<Chemical> l = get(chemicals);
		System.out.println(l.size());
		
	}
	static ArrayList<Chemical> get(Chemical[] chemicals){
		ArrayList<Chemical> list = new ArrayList<>();
		Arrays.sort(chemicals);//높은 온도 기준 오름차순 정렬
		list.add(chemicals[0]);//약품 한 개 추가 높을 수 있는 온도가 가장 낮을 것.
		
		for(int i=1,size=chemicals.length; i<size; i++) {
			if(list.get(list.size()-1).high<=chemicals[i].row) {
				list.add(chemicals[i]);
			}
		}
		return list;
	}
	
	
	static class Chemical implements Comparable<Chemical>{
		
		int row;
		int high;
		
		public Chemical(int row, int high) {
			super();
			this.row = row;
			this.high = high;
		}

		@Override
		public int compareTo(Chemical o) {
			int value = this.high-o.high;
			if(value!=0) {
				return value;
			}
			return this.row-o.row;
			
		}
		
		
		
	}

}
