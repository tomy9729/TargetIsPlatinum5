package week6.day0820;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_3234 {

	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	static int N;
	static int Max;
	static int[] ary;
	static int[] num;
	static boolean[] isSelected;
	static Queue<Queue> Q1;
	static Queue<Queue> Q2;
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {
			N = Integer.parseInt(br.readLine());
			ary = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				ary[i] = Integer.parseInt(st.nextToken());
			}
			isSelected = new boolean[N];
			num = new int[N];
			Q1 = new LinkedList<>();
			Q2 = new LinkedList<>();
			permutaion(0);

			sb.append("#" + tc + " " + Max + "\n");
		}
		System.out.println(sb.toString());
	}

	private static void permutaion(int cnt) {
		if (cnt == N) {
			middle(num);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (isSelected[i])
				continue;
			num[cnt] = i;
			isSelected[i] = true;
			permutaion(cnt+1);
			isSelected[i] = false;
		}

	}

	private static void middle(int[] nu) {
		
		
		
	}
	static void powerSetDupPer(int toChoose, boolean[] choosed) {
        if (toChoose == 0) {//기저조건!
        	print(choosed);
        	return;
        }
            choosed[toChoose - 1] = true; //처음에는 다 true로 진행하고
            powerSetDupPer(toChoose - 1, choosed); //true로 넣어준 다음에
            choosed[toChoose - 1] = false; //다음에는 false로 바꿔서 진행하면 모든 경우의 수를 볼 수 있겠다!
            powerSetDupPer(toChoose - 1, choosed);
    }

}
