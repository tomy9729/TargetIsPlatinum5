package algol.notSolved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class Line {
	long x;
	long y;

	Line(long x, long y) {
		this.x = x;
		this.y = y;
	}
}

public class Line_2170 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		List<Line> list = new ArrayList<>();

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			long x = Integer.parseInt(st.nextToken());
			long y = Integer.parseInt(st.nextToken());

			list.add(new Line(x, y));
		}

		// 1. 정렬하기
		Collections.sort(list, new Comparator<Line>() {

			@Override
			public int compare(Line o1, Line o2) {
				// 우선순위 1 > x 비교
				if (o1.x > o2.x)
					return 1;
				// 우선순위2 > x값이 같은 경우는 y값으로 비교
				else if (o1.x == o1.x) {
					if (o1.y > o2.y) {
						return 1;
					}
				}
				return -1;
			}
		});

		long start = list.get(0).x;
		long end = list.get(0).y;
		long sum = end - start;

		for (int i = 1; i < list.size(); i++) {
			long nextStart = list.get(i).x;
			long nextEnd = list.get(i).y;

			// 포함되는 경우
			if ((start <= nextStart) && (nextEnd <= end)) {
				continue;
			} // 일부 포함되는 경우
			else if (nextStart < end) {

				sum += (nextEnd - nextStart) - (end - nextStart);
			} // 포함 안되는 경우
			else {
				sum += (nextEnd - nextStart);
			}

			start = nextStart;
			end = nextEnd;

		}

		System.out.println(sum);

	}

}
/*
import java.io.*;
import java.util.*;

class Point {
    long x, y;

    Point(long x, long y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Point> lines = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            
            lines.add(new Point(x, y));
        }

        // 오름차순으로 정렬
        lines.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.x > o2.x) {
                    return 1;
                } else if (o1.x == o2.x) {
                    if (o1.y > o2.y) {
                        return 1;
                    }
                }
                return -1;
            }
        });

        long s = lines.get(0).x;
        long e = lines.get(0).y;
        long sum = e - s;

        for (int i = 1; i < lines.size(); i++) {
            long ns = lines.get(i).x;
            long ne = lines.get(i).y;

            if ((s <= ns) && (ne <= e)) {   // 이전 선분에 전부 포함되는 경우
                continue;
            } else if (ns < e) {    // 이전 선분에 start 점이 있는 경우
                sum += -(e - ns) + (ne - ns);
            } else {    // 겹치지 않는 경우
                sum += ne - ns;
            }
            s = ns;
            e = ne;
        }

        bw.write(sum + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}*/
