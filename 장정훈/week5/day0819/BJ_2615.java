package week6.day0819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2615 {

	static BufferedReader br;
	static StringTokenizer st;
	static int[][] map;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[21][21];//범위체크를 하지 않도록 크기를 행과 열 2씩 늘린다.
		
		//4가지 오목의 체크 방향 : 주의점. 왼쪽 우선, 왼쪽 좌표가 같다면 맨 위
		//오른쪽 이동, 아래쪽 이동, 오른쪽 아래 이동, 오른쪽 위 이동
		int[] dx = {0, 1, 1, -1};
		int[] dy = {1, 0, 1, 1};
		boolean flag = true;
		for(int i=1; i<20; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=1; j<20; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}//초기 데이터 입력 끝
		
		
		for(int i=1; i<20; i++) {
			for(int j=1; j<20; j++) {
				int currVal = map[i][j];
				if(currVal ==0) {
					continue;
				}//0일 때는 볼 필요가 없다.
				
				for(int d=0; d<4; d++) {
					//현재의 위치에서 진행하려는 방향의 반대 방향의 첫번째 값을 가져와서 현재와 같은지 확인.
					//같은 값이면 볼 필요 없다. 이미 이전에서 확인 했던 곳이기 때문에.
					if(currVal == map[i + dx[d]*-1][j+dy[d]*-1] ) {
						continue;
					}
					int cnt = 1;//현재 위치도 개수에 포함되기 때문에 1로 시작
					while(currVal==map[i + dx[d]*cnt][j+dy[d]*cnt]) {
						cnt++;
					}
					if(cnt==5) {
						System.out.println(currVal);
						System.out.print(i+" "+j);
						flag = false;
					}//오목이 됨
					
					
				}//4가지 방향 탐색
				
			}
		}
		//여기까지 왔다는 건 오목이 없었다는 뜻.
		if(flag) {
			System.out.println(0);
		}
		
	}

}
