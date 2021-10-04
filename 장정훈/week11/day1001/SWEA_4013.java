package week12.day1001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_4013 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int K;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			int result = 0;
			K = Integer.parseInt(br.readLine());
			map = new int[5][8];
			for(int i=1; i<5; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int j=0; j<8; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					//빨간색 12시 방향부터 시계방향으로 입력
					//0(12시) 1 2(3시) 3 4(6시) 5 6(9시) 7
				}
			}
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine()," ");
				int num = Integer.parseInt(st.nextToken());//돌릴 거
				int way = Integer.parseInt(st.nextToken());//방향
				boolean[] check = new boolean[5];
				play(num,way,check);
//				for(int[] arr : map) {
//					System.out.println(Arrays.toString(arr));
//				}
//				System.out.println();				
			}
			
//			shuffle(1, -1);
//			
//			for(int[] arr : map) {
//				System.out.println(Arrays.toString(arr));
//			}
			
			for(int i=1; i<5; i++) {
				if(map[i][0]==1) {
					result += Math.pow(2, i-1);
				}
			}
			
			
			sb.append("#"+t+" "+result+"\n");
		}
		System.out.println(sb.toString());
	}

	private static void play(int num, int way, boolean[] check) {
		if(check[num]) {
			return;
		}
		check[num] = true;
		int left = map[num][6];
		int right = map[num][2];
		shuffle(num, way);
		
		if(num == 1) {
			int rightCircle = map[2][6];
			if(right != rightCircle) {
				
				play(num+1, way*-1,check);
			}
		}else if(num == 4) {
			int leftCircle = map[3][2];
			if(left != leftCircle) {
				play(num-1, way*-1,check);
			}
		}else{
			//양쪽 확인
			int leftCircle = map[num-1][2];
			int rightCircle = map[num+1][6];
			if(left == leftCircle && right == rightCircle) {
				//양쪽 다 같은 극일 때
				return;
			}
			else if(left != leftCircle && right == rightCircle) {
				//왼쪽은 다른 극이고 오른쪽은 같은 극일 때 -> 왼쪽 자석은 현재 돌리는 자석과 반대방향으로 돌아감
				play(num-1,way*-1,check);
			}else if(left == leftCircle && right != rightCircle) {
				//왼쪽은 다른 극이고 오른쪽은 같은 극일 때 -> 왼쪽 자석은 현재 돌리는 자석과 반대방향으로 돌아감
				play(num+1, way*-1 , check);
			}else if(left != leftCircle && right != rightCircle) {
				//양쪽 극이 다 다를 때 양쪽 극이 현재 돌리는 자석과 반대방향으로 돌아감
				play(num-1,way*-1,check);
				play(num+1,way*-1,check);
			}
			
		}
		
	}

	private static void shuffle(int num, int way) {

		if(way==1) {
			int tmp = map[num][7];
			for(int i=6; i>=0; i--) {
				map[num][i+1] = map[num][i];
			}
			map[num][0] = tmp;
		}else {
			int tmp = map[num][0];
			for(int i=1; i<8; i++) {
				map[num][i-1] = map[num][i];
			}
			map[num][7] = tmp;
		}
		
	}
}
