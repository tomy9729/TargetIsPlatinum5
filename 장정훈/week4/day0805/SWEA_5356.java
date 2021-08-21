package week4.day0805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_5356 {

	public static String[][] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int n=1; n<N+1; n++) {
			arr = new String[5][15];			
			for(int i=0; i<5; i++) {
				String str = br.readLine();
				for(int j=0; j<str.length(); j++) {
					arr[i][j] = str.charAt(j)+"";
				}
			}
			
//			sb.append("#"+n+"\0");
			String str = "";
			for(int j=0; j<15; j++) {
				for(int i=0; i<5; i++) {
					if(arr[i][j]==null) {
						continue;
					}
					str += arr[i][j];
//					sb.append(arr[i][j]);
				}
			}
//			sb.append("\n");
			System.out.println("#"+n+" "+str);
		}
//		System.out.println(sb.toString());
	}

}
