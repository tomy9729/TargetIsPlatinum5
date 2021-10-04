package week12.day0926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class testReady {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static List<Person> list;
	static PriorityQueue<Person> PQ;
	static Person[] ary;

	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		PQ = new PriorityQueue<>();
		ary = new Person[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
//			list.add(new Person(i, age, name));
			PQ.offer(new Person(i, age, name));
			ary[i] = new Person(i, age, name);
		}

		//
//		for (int i = 0; i < n; i++) {
//			for (int j = i; j < n; j++) {
//				if (ary[i].age > ary[j].age) {
//					Person temp = new Person(ary[i].no, ary[i].age, ary[i].name);
//					ary[i] = ary[j];
//					ary[j] = temp;
//				}
//			}
//		}
//
//		for (int i = 0; i < n; i++) {
//			for (int j = i; j < n; j++) {
//				if (ary[i].age == ary[j].age) {
//					if (ary[i].no > ary[j].no) {
//						Person temp = new Person(ary[i].no, ary[i].age, ary[i].name);
//						ary[i] = ary[j];
//						ary[j] = temp;
//					}
//				}
//			}
//		}

		for (Person p : ary) {
//			System.out.println(p);
			sb.append(p+"\n");
		}
		System.out.println(sb.toString());
//		Collections.sort(list);
//		for(Person p : list) {
//			System.out.println(p);
//		}
		while(!PQ.isEmpty()) {
			Person p = PQ.poll();
			sb.append(p+"\n");//Person에 있는 toString으로 출력
		}
		System.out.println(sb.toString());
	}

	static class Person implements Comparable<Person> {

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
			return age + " " + name;
		}

		@Override
		public int compareTo(Person o) {
			if (!this.name.equals(o.name)) {
//				return this.name.compareTo(o.name);
				return this.name.compareTo(o.name) * -1;
			}
			return Integer.compare(this.age, o.age);
		}

	}
}
