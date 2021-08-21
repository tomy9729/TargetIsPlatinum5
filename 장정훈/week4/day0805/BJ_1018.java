package week4.day0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1018 {
	
	public static String[] strAryTypeA = 
	   {"WBWBWBWB", 
		"BWBWBWBW" ,
		"WBWBWBWB" , 
		"BWBWBWBW" , 
		"WBWBWBWB" , 
		"BWBWBWBW" , 
		"WBWBWBWB" , 
		"BWBWBWBW"};
	public static String[] strAryTypeB = 
	   {"BWBWBWBW",
		"WBWBWBWB" , 
		"BWBWBWBW" ,
		"WBWBWBWB" , 
		"BWBWBWBW" , 
		"WBWBWBWB" , 
		"BWBWBWBW" , 
		"WBWBWBWB"  
		};
	public static int M = 8;
	public static int H;
	public static int W;
	public static char[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-gen0erated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] hw = br.readLine().split(" ");
		H = Integer.parseInt(hw[0]);
		W = Integer.parseInt(hw[1]);
//		System.out.println(x+"---"+y);
		map = new char[H][W];
		for(int i=0; i<H; i++) {
			String str = br.readLine();
			map[i] = str.toCharArray();
		} 
		int min = Integer.MAX_VALUE;
		for(int i=0; i<=H-M; i++) {
			for(int j=0; j<=W-M; j++) {
				min = Math.min(min, Catch(i,j));
			}
		}
		sb.append(min);
		System.out.println(sb.toString());
		
	}
	private static int Catch(int r, int c) {
		int minA=0;
		int minB=0;
		for(int i=0; i<M; i++) {
			for(int j=0; j<M; j++) {
				if(map[i+r][j+c] == strAryTypeA[i].charAt(j)) {
					minA++;
				}
				if(map[i+r][j+c] == strAryTypeB[i].charAt(j)) {
					minB++;
				}
			}
		}
		
		
		return Math.min(minA, minB);
	}

}
