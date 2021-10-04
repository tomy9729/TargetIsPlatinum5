package week7.day0824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_3289 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M;//N은 최대 크기, M은 연산 개수
	
	static int[] infoAry;

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			
			st = new StringTokenizer(br.readLine()," ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			infoAry = new int[N+1];
			make();
			sb.append("#"+t+" ");
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int T = Integer.parseInt(st.nextToken());//연산 정보 0은 합집합, 1은 A,B가 같은 집합에 있는지 확인
				int A = Integer.parseInt(st.nextToken());//숫자 A
				int B = Integer.parseInt(st.nextToken());//숫자 B
				if(T==0) {
					union(A,B);
				}else {
					if(find(A)==find(B)) {
						sb.append("1");
					}else {
						sb.append("0");
					}
				}
			}			
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}


	private static void make() {
		for(int i=1; i<N+1; i++) {
			infoAry[i] = i;
		}
		
	}
	private static int find(int a) {
		//a가 속한 집합의 대표자 찾기
		if(a==infoAry[a]) return a;
		
		return infoAry[a] = find(infoAry[a]);//자신이 속한 집합의 대표자를 자신의 부모로 : path compression
	}

	private static void union(int a, int b) {
		//두 원소를 하나의 집합으로 합치기(대표자를 이용해서 합침);
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot == bRoot) return;//이미 같은 집합으로 합치지 않음.
		
		infoAry[bRoot] = aRoot;
	
	}
	
	

}
