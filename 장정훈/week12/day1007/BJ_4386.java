package week13.day1007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_4386 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static Point[] point;
	
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		point = new Point[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			point[i] = new Point(x, y, i);
		}

	}
	
	private static double getZ(Point p1, Point p2) {
		double a = Math.pow((p1.x - p2.x), 2);//어차피 제곱이니깐 음수 양수 상관없다.
		double b = Math.pow((p1.y - p2.y), 2);//어차피 제곱이니깐 음수 양수 상관없다.
		return Math.sqrt(a+b);
		//피타고라스 
	}
	
	
	static class Point{
		double x,y;
		int num;
		public Point(double x, double y, int num) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
		}
		
	}
}
