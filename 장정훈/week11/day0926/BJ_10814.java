package week12.day0926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_10814 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static List<Person> list;
	static PriorityQueue<Person> PQ;
	
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		PQ = new PriorityQueue<>();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
//			list.add(new Person(i, age, name));
			PQ.offer(new Person(i, age, name));
		}
		
		
		
//		Collections.sort(list);
//		for(Person p : list) {
//			System.out.println(p);
//		}
		while(!PQ.isEmpty()) {
			sb.append(PQ.poll()+"\n");
		}
		System.out.println(sb.toString());
	}
	static class Person implements Comparable<Person>{
		
		int no;
		int age;
		String name;
		

		public Person(int no, int age, String name) {
			super();
			this.no = no;
			this.age = age;
			this.name = name;
		}

		@Override
		public String toString() {
			return age+" "+name;
		}

		@Override
		public int compareTo(Person o) {
			if(this.age != o.age) {
				return Integer.compare(this.age, o.age);
			}
			return Integer.compare(this.no, o.no);
		}

		
		
	}
}
