package week6.day0818;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5644 {

	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int Max;
	static int M, A;// 이동개수 M, AP개수 A
	static Queue<Integer> personA;// A가 움직일 거리 저장
	static Queue<Integer> personB;// B가 움직일 거리 저장
	static Person[] person;
	static AP[] ap;
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
			ap = new AP[A];
			sum = 0;
			person[0] = new Person(1, 1);
			person[1] = new Person(10, 10);
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
				ap[a] = new AP(i, j, c, p);
			}

			play(0);
//			System.out.println(person[0].move);
			sb.append("#" + tc + " " + sum + "\n");
		}
		System.out.println(sb.toString());
	}

	private static void play(int cnt) {
		if (cnt == 20) {
			return;
		}
		
		Queue<Integer> A = check(person[0].i, person[0].j);// 충전 가능한 위치를 큐로 받아옴.
		Queue<Integer> B = check(person[1].i, person[1].j);// 충전 가능한 위치를 큐로 받아옴.
//		if(A.isEmpty()&&B.isEmpty()) {
//			person[0].move();
//			person[1].move();
//		}else 
		if (A.isEmpty() && !B.isEmpty()) {
			int x = B.size();
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < x; i++) {
				max = Math.max(max, ap[B.poll()].P);
			}
			sum += max;
		} else if (!A.isEmpty() && B.isEmpty()) {
			int x = A.size();
			int max = Integer.MIN_VALUE;
			for (int i = 0; i < x; i++) {
				max = Math.max(max, ap[A.poll()].P);
			}
			sum += max;
		} else if (!A.isEmpty() && !B.isEmpty()) {
			int aSize = A.size();
			int bSize = B.size();
			int[] ary1 = new int[aSize];
			int aMax = Integer.MIN_VALUE;
			int aa = 0;
			for (int a = 0; a < aSize; a++) {
				ary1[a] = A.poll();
//				aMax = Math.max(aMax, ap[ary1[a]].C);
				if (aMax < ap[ary1[a]].P) {
					aMax = ap[ary1[a]].P;
					aa = ary1[a];
				}
			}

			int[] ary2 = new int[bSize];
			int bMax = Integer.MIN_VALUE;
			int bb = 0;
			for (int b = 0; b < bSize; b++) {
				ary2[b] = B.poll();
				if (bMax < ap[ary2[b]].P) {
					bMax = ap[ary2[b]].P;
					bb = ary2[b];
				}
			}
			boolean flag = true;
			for (int a = 0; a < aSize; a++) {
				for (int b = 0; b < bSize; b++) {
					if (ary1[a] == ary2[b]) {
						flag = false;
					}
				}
			}
			if (flag) {
				sum += (bMax + aMax);
			} else {
				if (bMax != aMax) {
					sum += (bMax + aMax);
				} else {

					int semiMax = 0;
					boolean check = true;
					for (int a = 0; a < aSize; a++) {
						int semi = 0;
						for (int b = 0; b < bSize; b++) {
							if (ary1[a] == ary2[b]) {
								semi = ap[ary2[b]].P;
							} else {
								semi = ap[ary2[b]].P + ap[ary1[a]].P;
							}
							semiMax = Math.max(semiMax, semi);
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

	private static Queue<Integer> check(int i, int j) {
		Queue<Integer> extra = new LinkedList<>();
		for (int a = 0; a < A; a++) {
			int c = ap[a].C;
			if ((Math.abs(i - ap[a].i) + Math.abs(j - ap[a].j)) <= c) {
				extra.add(a);
			}
		}
		return extra;
	}

	static class Person {
		int i, j;// 좌표 A라는 사람은 0,0 B라는 사람은 9,9\
		int p;// A/B가 충전할 수 있는 용량.
		int[][] deltas = { { 0, 0 }, { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
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

	static class AP {
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

	}

}
