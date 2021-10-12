package week13.day1006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_4014 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int result;
	static int N, X;
	static int[][] map;
	static int ttt;
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			ttt=t;
			result = 0;
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			play();

			sb.append("#" + t + " " + result + "\n");
		}
		System.out.println(sb.toString());
	}

	private static void play() {
		int[] arr;
		int[] visited;
		for (int i = 0; i < N; i++) {
			arr = new int[N];
			visited = new int[N];
			for (int j = 0; j < N; j++) {
				arr[j] = map[i][j];
			}
			
			if(solve(arr, visited) && solve(reverse(arr), reverse(visited))) {
				result++;
			}
			
//			
		}

		for (int i = 0; i < N; i++) {
			arr = new int[N];
			visited = new int[N];
			for (int j = 0; j < N; j++) {
				arr[j] = map[j][i];
			}
			
			if(solve(arr, visited) && solve(reverse(arr), reverse(visited))) {
				result++;
			}
//			
		}

	}

	private static boolean solve(int[] arr, int[] visited) {
		boolean flag = true;
		int cnt = arr[0];
		for(int i=0; i<N; i++) {
			if(cnt != arr[i]) {
				//한 줄에서 하나라도 다르면 시작.
				//다 같으면 flag는 true이므로 
				
				flag = false;
			}
		}
		if(flag) {
			return true;
		}
//		if(arr[X-1]>arr[X-2]) {
//			//X가 2라고 가정
//			//1 2 1 1 ...형태라면 뒤집어도 오르막 형성이 불가능 하므로 false반환
//			//1 1 2 1 ...이면 확인 해봐야 됨.
//			//X가 3이라 가정
//			//1 1 2 1 1 1... 형태가 되어도 불가능
//			//1 2 2 1 1 1... 일때는 판별 불가능 -> 밑에서 처리
//			return false;
//		}
		cnt =0;
		for(int i=1; i<X; i++) {
			if(arr[i-1]<arr[i]) {
				return false;
			}//바깥쪽 부분이 작아지면 X 길이만큼 들어갈 수 있는 공간이 안 생기기 때문에.
			if(arr[i-1]>arr[i]) {
				cnt++;
			}
			if(cnt==2) {
				return false;
			}//안쪽에서 0~X-1부분에서 작아지는 부분이 두 번이상이 나오면 
		}
		int[] selected = new int[7];
		//-,1,2,3,4,5,6 높이를 얼마나 쓰고 있는지 확인
		//selected
		for(int i=0; i<X; i++) {
			selected[arr[i]]++;
		}//0~X-1의 값으로 초기화
		//오르막길만 보자
		for(int i=X; i<N; i++) {
			if(arr[i]-1 > arr[i-1]) {
				return false;
			}else if(arr[i]-1 == arr[i-1]) {
				if(selected[arr[i-1]]!=X) {
					
					return false;
				}else {
					for(int j = i-X; j<i; j++) {
						visited[j]++;
					}
				}
			}
			selected[arr[i]]++;
			selected[arr[i-X]]--;
			
		}
		
		
		
		
		
		
		for(int i=0; i<N; i++) {
			if(visited[i] >1) {
				//사실 2가 최대
				return false;
			}
		}
		
		return true;
	}

	private static int[] reverse(int[] arr) {
		int[] reverse = new int[arr.length];

		int i = 0;
		for (int j = arr.length - 1; j >= 0; j--) {
			reverse[i++] = arr[j];
		}

		return reverse;
	}
}
