package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17136 {

	static int R = 10, C = 10;
	static int[] paper = {0,5,5,5,5,5};
	static int ans, min=26;
	static boolean flag = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		boolean[][] arr = new boolean[10][10];
		
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				if(Integer.parseInt(st.nextToken())==1)
					arr[i][j] =true ;
				else arr[i][j] = false ;
			}
		}

		bfs(0,arr,0);
		
		if(min==26)
			System.out.println(-1);
		else if(!flag)
			System.out.println(0);
		else 
			System.out.println(min);
	}

	private static void bfs(int cnt, boolean[][] map,int result) {
		boolean[][] nArr;
		int r = cnt / 10;
		int c = cnt % 10;

		// 종료조건
		if (cnt==100) {
			min = result;
			return;
		}
		
		if(result>min) {
			return;
		}
		
		// 0이라면
		if (!map[r][c]) {
			bfs(cnt + 1,map,result);
		}
		// 1이라면
		else {
			
			//한 번이라도 타지 않았다면 모든 요소가 0이라는 뜻
			flag=true;
			
			// 정사각형을 만들 수 있는 최대 길이
			int N = getN(r,c,map);
			
			// 길이가 N인 정사각형부터 1인 정사각형까지 모든 경우 탐색
			for(int i=N;i>=1;i--) {
				
				// 내부가 비어있지 않으면 진행
				if(check(r,c,i,map)) {		
					// 만약 해당 길이의 덮어쓸 색종이가 없으면 pass
					if((paper[i]-1)>=0) {
						
						// 지금까지 들어온 배열을 복사 후 진행
						nArr = new boolean[10][10];
						copy(map,nArr);
						
						// 색종이로 덮기
						paper[i]--;			
						fillArr(r,c,i,nArr);
						bfs(cnt+1,nArr,result+1);
						paper[i]++;	
					}else {
						continue;
					}
				}
			}	
		}
		
		return;

	}
	
	// 배열을 복사하는 함수 ( main -> copy )
	private static void copy(boolean[][] main,  boolean[][] copy){
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				copy[i][j] = main[i][j];
			}
		}
	}
	
	// 현재 위치(r,c)부터 정사각형을 만들 수 있는 최대 길이 반환하는 함수
	private static int getN(int r, int c,boolean[][] map) {
		int[] RC = { 0, 0 }; // 세로, 가로
		int count = 0;
		while (count<=4) {
			if (inIn(r+count,c) && map[r + count++][c])
				RC[0]++;
			else break;
		}

		count = 0;
		while (count<=4) {
			if (inIn(r,c+count) && map[r][c + count++])
				RC[1]++;
			else break;
		}
		
		return Math.min(RC[0], RC[1]);
	}

	// 해당 공간이 1(true)로 채워져있는지 확인하는 함수
	private static boolean check(int r, int c, int n, boolean[][] map) {
		for (int i = r; i < r + n; i++) {
			for (int j = c; j < c + n; j++) {
				if (!map[i][j])
					return false;
			}
		}
		return true;
	}

	// 해당 공간을 색종이로 덮어 0(false)로 만들어주는 함수
	private static void fillArr(int r, int c, int n, boolean[][] map) {
		for (int i = r; i < r + n; i++) {
			for (int j = c; j < c + n; j++) {
				map[i][j] = false;
			}
		}
	}
	
	// 배열 영역 내에 있는지 검사하는 함수
	private static boolean inIn(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}
}
