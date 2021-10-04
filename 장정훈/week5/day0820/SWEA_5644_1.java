package week6.day0820;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5644_1 {

	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int Max;
	static int M, A;// 이동개수 M, AP개수 A
	static Queue<Integer> personA;// A가 움직일 거리 저장
	static Queue<Integer> personB;// B가 움직일 거리 저장
	static Person[] person;
	static List<AP> ap;
	static int sum;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("input_SWEA5644.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
//			System.out.println(M + "::::" + A);
			Max = Integer.MIN_VALUE;
			person = new Person[2];
			ap = new ArrayList<>();
			sum = 0;
			person[0] = new Person(1, 1);
			person[1] = new Person(10, 10);
			person[0].move.add(0);
			person[1].move.add(0);
			for (int m = 0; m < 2; m++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int i = 0; i < M; i++) {
					person[m].move.add(Integer.parseInt(st.nextToken()));
				}
			}
			for (int a = 0; a < A; a++) {
				st = new StringTokenizer(br.readLine(), " ");
//				ap[a] = new AP(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				ap.add(new AP(i, j, c, p));
			}
			Collections.sort(ap);
//			for(AP a: ap) {
//				System.out.println(a);
//			}
//			System.out.println();
			play(0);
//			System.out.println(person[0].move);
			sb.append("#" + tc + " " + sum + "\n");
		}
		System.out.println(sb.toString());
	}

	private static void play(int cnt) {
		if (cnt == M+1) {
			return;
		}
		
		List<Integer> A = check(person[0].i, person[0].j);// 충전 가능한 위치를 큐로 받아옴.
		Collections.sort(A);
		List<Integer> B = check(person[1].i, person[1].j);// 충전 가능한 위치를 큐로 받아옴.
		Collections.sort(B);
		int aSize = A.size();
		int bSize = B.size();
//		if(A.isEmpty()&&B.isEmpty()) {
//			person[0].move();
//			person[1].move();
//		}else 
		if (A.isEmpty() && !B.isEmpty()) {
			
//			int max = Integer.MIN_VALUE;
//			for (int i = 0; i < bSize; i++) {
//				max = Math.max(max, ap.get(B.poll()).P);
//			}
			sum += ap.get(B.get(0)).P;
		} else if (!A.isEmpty() && B.isEmpty()) {
//			int max = Integer.MIN_VALUE;
//			for (int i = 0; i < aSize; i++) {
//				max = Math.max(max, ap.get(A.poll()).P);
//			}
			sum += ap.get(A.get(0)).P;
		} else if (!A.isEmpty() && !B.isEmpty()) {
			
			int[] ary1 = new int[aSize];
			int aMax = ap.get(A.get(0)).P;
			int[] ary2 = new int[bSize];
			int bMax = ap.get(B.get(0)).P;
			
			int aa = 0;
			int bb = 0;
			
			for (int a = 0; a < aSize; a++) {
//				ary1[a] = A.poll();
//				aMax = Math.max(aMax, ap[ary1[a]].C);
				if (aMax < ap.get(A.get(a)).P) {
					aMax = ap.get(A.get(a)).P;
					aa = ary1[a];
				}
			}
			
			for (int b = 0; b < bSize; b++) {
//				ary2[b] = B.poll();
				if (bMax < ap.get(B.get(b)).P) {
					bMax = ap.get(B.get(b)).P;
					bb = ary2[b];
				}
			}
			boolean flag = true;
			outer : for (int a = 0; a < aSize; a++) {
				for (int b = 0; b < bSize; b++) {
					if (A.get(a) == B.get(b)) {
						flag = false;
						break outer;
					}
				}
			}
			if (flag) {//겹치는 곳이 없음.
				sum += (bMax + aMax);
			} else {
				if(aSize==1&&bSize==1) {//겹치는 곳이 있는데 다른 AP로부터 충전을 못 받으면 하나로 둘이 나눠야 한다.
					sum += aMax;
				}else if(aMax!=bMax) {//겹치는 곳이 있는데 각자 가지고 있는 최대값이 다르면 각각 더함.
					sum += (aMax+bMax);
				}else if(aMax==bMax){//겹치는 곳이 있고 겹치는 곳이 최대값일 때.
					int semiMax = 0;
					for(int i=0; i<aSize; i++) {
						for(int j=0; j<bSize; j++) {
							if(A.get(i)==B.get(j)) {
								semiMax = Math.max(semiMax, ap.get(A.get(i)).P);
							}else {
								semiMax = Math.max(semiMax, (ap.get(A.get(i)).P+ap.get(B.get(j)).P));
							}
						}
					}
					sum += semiMax;
				}
			}

		}

		person[0].move();
		person[1].move();
		play(cnt + 1);
	}

	private static List<Integer> check(int i, int j) {
		List<Integer> extra = new ArrayList<>();
		for (int a = 0; a < A; a++) {
			int c = ap.get(a).C;
			if ((Math.abs(i - ap.get(a).i) + Math.abs(j - ap.get(a).j)) <= c) {
				extra.add(a);
			}
		}
		return extra;
	}

	static class Person {
		int i, j;// 좌표 A라는 사람은 0,0 B라는 사람은 9,9\
		int p;// A/B가 충전할 수 있는 용량.
		int[][] deltas = { { 0, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };
		Queue<Integer> move = new LinkedList<>();

		public Person(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}

		public void move() {
			int m = move.poll();

			this.i += this.deltas[m][0];
			this.j += this.deltas[m][1];
		}

	}

	static class AP implements Comparable<AP> {
		int i, j;// AP의 좌표
		int C;// AP의 충전 가능 범위
		int P;// AP의 충전 성능 -> 두 명이 동시 접속 하면 2가 나눠진다.

		public AP(int i, int j, int c, int p) {
			super();
			this.i = i;
			this.j = j;
			this.C = c;
			this.P = p;
		}

		@Override
		public int compareTo(AP o) {
//			return o.P - this.P;
			return Integer.compare(this.P, o.P)*-1;
		}

		@Override
		public String toString() {
			return "AP [i=" + i + ", j=" + j + ", C=" + C + ", P=" + P + "]";
		}

	}

}
