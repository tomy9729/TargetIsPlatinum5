package week12.day0930;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_5643 {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M;
	static List<Integer>[] bigList;
	static List<Integer>[] smallList;
	static boolean [][] check;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input_SWEA5643.txt"));
		br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int result = 0;
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			bigList = new ArrayList[N+1];
			smallList = new ArrayList[N+1];
			check = new boolean[N+1][N+1];
			for(int i=1; i<=N; i++) {
				bigList[i] = new ArrayList<>();
				smallList[i] = new ArrayList<>();
			}
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				bigList[A].add(B);//B가 A보다 크다
				smallList[B].add(A);//A가 B보다 작다
			}
			
			for(int i=1; i<=N; i++) {
				play(i);
			}
			
			result = aryCheck();
			
			sb.append("#"+t+" "+result+"\n");
		}
		System.out.println(sb);
	}

	private static void play(int idx) {
		
		Queue<Integer> Q = new LinkedList<>();
		for(int i=0; i<bigList[idx].size(); i++) {
			Q.offer(bigList[idx].get(i));
			check[idx][bigList[idx].get(i)] = true;
		}
		
		
		// 확인 하는 노드와 연결관계가 존재하는 쪽 확인하기
		while(!Q.isEmpty()) {
			int pollNum = Q.poll();
			if(bigList[pollNum] != null) {
				for(int i=0; i<bigList[pollNum].size(); i++) {
					if(check[idx][bigList[pollNum].get(i)]) {
						continue;
					}
					Q.offer(bigList[pollNum].get(i));
					check[idx][bigList[pollNum].get(i)] = true;
				}
			}
			
		}
		
//		System.out.println("큰 거 확인"+Arrays.toString(check[idx]));

		
		for(int i=0; i<smallList[idx].size(); i++) {
			if(!check[idx][smallList[idx].get(i)]) {
				Q.offer(smallList[idx].get(i));
				check[idx][smallList[idx].get(i)] = true;
			}
		}//확인하는 노드와 직접 연결되어 있는 부분 확인 처리
		
		while(!Q.isEmpty()) {
			int pollNum = Q.poll();
			if(smallList[pollNum] != null) {
				for(int i=0; i<smallList[pollNum].size(); i++) {
					if(check[idx][smallList[pollNum].get(i)]) {
						continue;
					}
					Q.offer(smallList[pollNum].get(i));
					check[idx][smallList[pollNum].get(i)] = true;
				}
			}
		}
		
//		System.out.println("작은 거 확인"+Arrays.toString(check[idx]));
		
	}

	private static int aryCheck() {
		int cnt = 0;
		for(int i=1; i<=N; i++) {
			boolean flag = true;
			for(int j=1; j<=N; j++) {
				if(i==j) {
					continue;
				}
				if(!check[i][j]) {
					flag = false;
					break;
				}
			}
			if(flag) {
				cnt++;
			}
		}
		
		return cnt;
	}
}
