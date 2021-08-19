//5644. 무선 충전.java
package com.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 무선_충전_5644 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static class BC implements Comparable<BC>{
		int x;
		int y;
		int C;
		int P;
		BC(int x, int y, int C, int P){
			this.x = x;
			this.y = y;
			this.C = C;
			this.P = P;
		}
		@Override
		public int compareTo(BC o) {
			int value = this.P - o.P;
			return value*-1;
		}
	}
	static int T;
	static int M;
	static int countBC;
	static int[] A;
	static int[] B;
	static BC[] bc;
	static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		T = Integer.parseInt(br.readLine());
		
		for(int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine()," ");
			M = Integer.parseInt(st.nextToken());
			countBC = Integer.parseInt(st.nextToken());
			A = new int[M];
			B = new int[M];
			bc = new BC[countBC];
			answer = 0;
			
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<M;i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine()," ");
			for(int i=0;i<M;i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0;i<countBC;i++) {
				st = new StringTokenizer(br.readLine()," ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				bc[i] = new BC(x,y,c,p);
			}
			
			//0이동하지않음 1상 2우 3하 4좌
			//배터리 처리량이 큰 순서대로 정렬
			Arrays.sort(bc);
			
			int[] positionA = {1,1};//x,y 
			int[] positionB = {10,10};
			
			for(int time=0;time<=M;time++) {
				
				//A와 B가 접근할 수 있는 배터리
				List<Integer> useA = new ArrayList<Integer>();
				List<Integer> useB = new ArrayList<Integer>();
				for(int b=0;b<countBC;b++) {
					if(Math.abs(positionA[0]-bc[b].x)+Math.abs(positionA[1]-bc[b].y)<=bc[b].C) {
						if(useA.size()<2) useA.add(b);
					}
					if(Math.abs(positionB[0]-bc[b].x)+Math.abs(positionB[1]-bc[b].y)<=bc[b].C) {
						if(useB.size()<2) useB.add(b);
					}
				}
				//A와 B가 사용할 배터리 결정하기
				if(useA.size()==0 && useB.size()==0)answer+=0;
				else if(useA.size()>=1 && useB.size()==0)answer += bc[useA.get(0)].P;
				else if(useA.size()==0 && useB.size()>=1)answer += bc[useB.get(0)].P;
				else if(useA.size()==1 && useB.size()==1) {
					if(useA.get(0)==useB.get(0))answer += bc[useA.get(0)].P;
					else {
						answer += bc[useA.get(0)].P;
						answer += bc[useB.get(0)].P;
					}
				}
				else if(useA.size()>=2 && useB.size()==1) {
					if(useA.get(0)!=useB.get(0) && useA.get(1)!=useB.get(0)) {
						answer += bc[useA.get(0)].P;
						answer += bc[useB.get(0)].P;
					}
					else if(useA.get(0)==useB.get(0)) {
						answer += bc[useA.get(1)].P;
						answer += bc[useB.get(0)].P;
					}
					else if(useA.get(1)==useB.get(0)) {
						answer += bc[useA.get(0)].P;
						answer += bc[useB.get(0)].P;
					}
				}
				else if(useA.size()==1 && useB.size()==2) {
					if(useA.get(0)!=useB.get(0) && useA.get(0)!=useB.get(1)) {
						answer += bc[useA.get(0)].P;
						answer += bc[useB.get(0)].P;
					}
					else if(useA.get(0)==useB.get(0)) {
						answer += bc[useA.get(0)].P;
						answer += bc[useB.get(1)].P;
					}
					else if(useA.get(0)==useB.get(1)) {
						answer += bc[useA.get(0)].P;
						answer += bc[useB.get(0)].P;
					}
				}
				else {
					if(useA.get(0)!=useB.get(0)) {
						answer += bc[useA.get(0)].P;
						answer += bc[useB.get(0)].P;
					}
					else {
						answer += bc[useA.get(0)].P;
						answer += Math.max(bc[useA.get(1)].P, bc[useB.get(1)].P);
					}
				}
				
				//A,B이동	
				if(time<M) {
					positionA = move(positionA[0],positionA[1],A[time]);
					positionB = move(positionB[0],positionB[1],B[time]);
				}
				
			}
			sb.append("#"+t+" "+answer+"\n");
		}
		System.out.println(sb.toString());
		
	}
	//0이동하지않음 1상 2우 3하 4좌
	public static int[] move(int x, int y, int d) {
		int[] nextIj = new int[2];
		if(d==0) {
			nextIj[0]=x;
			nextIj[1]=y;
		}
		else if(d==1) {
			nextIj[0]=x;
			nextIj[1]=y-1;
		}
		else if(d==2) {
			nextIj[0]=x+1;
			nextIj[1]=y;
		}
		else if(d==3) {
			nextIj[0]=x;
			nextIj[1]=y+1;
		}
		else if(d==4) {
			nextIj[0]=x-1;
			nextIj[1]=y;
		}
		
		return nextIj;
	}
}
