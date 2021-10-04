package week6.day0818;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5644_2 {

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
		List<Integer> nearA = check(person[0].x, person[0].y);
		List<Integer> nearB = check(person[1].x, person[1].y);

		boolean flag = true;
		out: for (int i = 0; i < nearA.size(); i++) {
			for (int j = 0; j < nearB.size(); j++) {
				if (nearA.get(i) == nearB.get(j)) {
					flag = false;
					break out;
				}
			}
		}
		if (flag) {// 겹치는 게 없음
			int maxA = 0;
			int maxB = 0;
			for (int i = 0; i < nearA.size(); i++) {
				maxA = Math.max(maxA, ap[nearA.get(i)].P);
			}
			for (int j = 0; j < nearB.size(); j++) {
				maxB = Math.max(maxB, ap[nearB.get(j)].P);
			}
			sum += maxA + maxB;
		} else {// 겹치는 게 있음;
			int maxA = 0;
			int maxB = 0;
			for (int i = 0; i < nearA.size(); i++) {
				maxA = Math.max(maxA, ap[nearA.get(i)].P);
			}
			for (int j = 0; j < nearB.size(); j++) {
				maxB = Math.max(maxB, ap[nearB.get(j)].P);
			}
			if (maxA != maxB) {//겹치는 게 있으나 최대값은 겹치지 않을 때.
				sum += maxA;
				sum += maxB;
			}else {
				int semiMax = 0;
				for (int i = 0; i < nearA.size(); i++) {
					for (int j = 0; j < nearB.size(); j++) {
						if (nearA.get(i) == nearB.get(j)) {
							semiMax = Math.max(semiMax, ap[nearB.get(j)].P);
						} else {
							semiMax = Math.max(semiMax, (ap[nearA.get(i)].P + ap[nearB.get(j)].P));
						}
					}
				}
				sum += semiMax;
			}
		}
		person[0].move();
		person[1].move();
		play(cnt + 1);
	}

	private static List<Integer> check(int x, int y) {
		List<Integer> extra = new ArrayList<>();
		for (int a = 0; a < A; a++) {
			int c = ap[a].C;
			if ((Math.abs(x - ap[a].x) + Math.abs(y - ap[a].y)) <= c) {
				extra.add(a);
			}
		}
		return extra;
	}

	static class Person {
		int x, y;// 좌표 A라는 사람은 1,1 B라는 사람은 10,10
		int[][] deltas = { { 0, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };// 제자리, 상, 우, 하, 좌
		Queue<Integer> move = new LinkedList<>();

		public Person(int x, int y) {
			super();
			this.x = y;
			this.x = y;
		}

		public void move() {
			int m = move.poll();

			this.x += this.deltas[m][0];
			this.y += this.deltas[m][1];
		}

	}

	static class AP {
		int x, y;// AP의 좌표
		int C;// AP의 충전 가능 범위
		int P;// AP의 충전 성능 -> 두 명이 동시 접속 하면 2가 나눠진다.

		public AP(int x, int y, int c, int p) {
			super();
			this.x = x;
			this.y = y;
			this.C = c;
			this.P = p;
		}

	}

}
