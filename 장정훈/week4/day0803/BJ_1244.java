package week4.day0803;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1244 {
	public static int[] ary;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		int x = Integer.parseInt(br.readLine());
		ary = new int[x];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<x; i++) {
			
			ary[i] =Integer.parseInt(st.nextToken());
		}
		int p = Integer.parseInt(br.readLine());
		int[][] pAry = new int[p][2];
		
		for(int i=0; i<p; i++) {
			st = new StringTokenizer(br.readLine()," ");
			pAry[i][0] = Integer.parseInt(st.nextToken());
			pAry[i][1] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<pAry.length; i++) {
			if(pAry[i][0] == 1) {
				checkM(pAry[i][1]);
			}else if(pAry[i][0] == 2) {
				checkW(pAry[i][1]);
			}
		}
//		for(int a: ary) {
//			sb.append(a).append(" ");
//		}
		for(int i=0; i<ary.length; i++) {
			sb.append(ary[i]);
			if(i==ary.length-1) {
				break;
			}
			if((i+1)%20==0) {
				sb.append("\n");
			}else {
				sb.append(" ");
			}
			
		}
		System.out.print(sb.toString());

	}

	public static void checkM(int i) {
		for(int j=i-1; j<ary.length; j++) {
			if((j+1)%i==0) {
				if(ary[j]==0) {
					ary[j] =1;
				}else if(ary[j] ==1) {
					ary[j] =0;
				}
			}
		}
		
	}
	public static void checkW(int i) {
		i-=1;
		for(int j=(i+1),l=(i-1); j<ary.length; j++) {
			if(l<0 || j>ary.length-1) {
				break;
			}else if(ary[j]!=ary[l]) {
				break;
			}
			if(ary[j]==ary[l]) {
				if(ary[j]==1) {
					ary[j]=0;
					ary[l]=0;
				}else if(ary[j] ==0) {
					ary[j]=1;
					ary[l]=1;
				}
			}
			l--;
		}
	
		if(ary[i]==1) {
			ary[i]=0;
		}else if(ary[i] ==0) {
			ary[i]=1;
		}
	
	}
	

}
