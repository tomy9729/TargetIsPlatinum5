package week4.day0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_7568 {
	public static int N;
	public static int[][] ary;
//	public static List<Person> plist;
//	public static Person person;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
//		plist = new ArrayList<>();
		ary = new int[N][2];
		for(int n=0; n<N; n++) {
			String[] str = br.readLine().split(" ");
//			person = new Person(Integer.parseInt(str[0]),Integer.parseInt(str[1]));
//			plist.add(person);
			ary[n][0] = Integer.parseInt(str[0]);
			ary[n][1] = Integer.parseInt(str[1]);
		}
		rank();
		
		System.out.println(sb.toString());
	}
	private static void rank() {
		// TODO Auto-generated method stub
		for(int i=0; i<N; i++) {
			int rank=1;
			for(int j=0; j<N; j++) {
				if(i==j) {
					continue;
				}
				
				if(ary[i][0]<ary[j][0] && ary[i][1]<ary[j][1]) {
					rank++;
				}
			}
			sb.append(rank+" ");
		}
	}
	

}
//class Person{
//	private int kg;
//	private int cm;
//	private int rank;
//		
//	public Person(int kg, int cm) {
//		this.kg = kg;
//		this.cm = cm;
//	}
//	public int getKg() {
//		return kg;
//	}
//	public void setKg(int kg) {
//		this.kg = kg;
//	}
//	public int getCm() {
//		return cm;
//	}
//	public void setCm(int cm) {
//		this.cm = cm;
//	}
//	public int getRank() {
//		return rank;
//	}
//	public void setRank(int rank) {
//		this.rank = rank;
//	}
//	
//	
//}
