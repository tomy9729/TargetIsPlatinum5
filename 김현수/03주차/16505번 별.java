//16505번 별.java
package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 별_16505 {
	private static char star[][]; 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int num=Integer.parseInt(bf.readLine()); 
		int size = (int) Math.pow(2, num);
		star = print_star(num+1,size*2);
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<size;i++) {
			for(int j=0;j<(size-i);j++) {
				sb.append(star[i][j]);							
			}sb.append("\n");
		}
		System.out.println(sb.toString().substring(0, sb.length()-1));
	}
	
	public static char[][] print_star(int num, int size) {
		char[][]star = new char[size][size];
		for(int i=0;i<size;i++) {
			Arrays.fill(star[i], ' ');
		} 
		if(num==0) {
			star[0][0]='*';
			return star;
		}
		
		char[][] pre_star = print_star(num-1,size/2);
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(j<size-i) {
					star[i][j]=pre_star[i%(size/2)][j%(size/2)];
				}
			}
		}
		return star;
	}
}
