package week7.day0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_15683 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,M;
	static int[][] map;
	static List<CCTV> cctvs;
	
	static int Min;
	
	static int totalBlind;
	
	//CCTV의 타입별로 가능한 방향을 정리.//타입, 방향, 감지 방향
	//방향 상0 하1 우2 좌3
	static int[][][] watch = {
			{},
			{{0},{1},{2},{3}},//1번
			{{0,1},{2,3}},//2번
			{{0,2},{2,1},{3,1},{0,3}},//3번
			{{0,1,2},{0,1,3},{0,2,3},{1,2,3}},//4번
			{{0,1,2,3}},//5번
	};
	
	//각 방향으로의 증분
	static int[][] deltas = {{-1,0},{1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		cctvs = new ArrayList<>();
		Min = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 0 &&map[i][j] !=6) {
					cctvs.add(new CCTV(i, j, map[i][j]));
				}else if(map[i][j] ==0) {
					totalBlind++;
				}
			}
		}
		
		dfs(0, 0);
		System.out.println(Min);
	}
	
	static void dfs(int idx,int clean) {
		
		if(idx == cctvs.size()) {
			//점검 완료 - 최소 영역 개수 반환
			Min = Math.min(Min, totalBlind - clean);
			return;
		}
		
		//현재 idx의 CCTV 가져오기
		CCTV cctv = cctvs.get(idx);
		
		//감시 가능한 방향으로 돌려보기 
		for(int d=0; d<watch[cctv.type].length; d++) {
			//할 일: 해당 방향 색칠하기
			int watched = scan(cctv,watch[cctv.type][d], -1);
			dfs(idx+1,clean+watched);
			
			//할 일: 해당 방향 원상복귀 시키기
			scan(cctv,watch[cctv.type][d], 1);
		}
	}
	
	
	/**
	 * 
	 * @param cctv 현재 CCTV
	 * @param dirs 바라볼 수 있는 방향
	 * @param flag 색칠할 거 복구할 거
	 * @return //색칠한 개수
	 */
	private static int scan(CCTV cctv, int[] dirs, int flag) {
		int cnt =0;
		for(int d=0; d<dirs.length; d++) {
			for(int i=1; ; i++) {
				int nr = cctv.r + deltas[dirs[d]][0]*i;
				int nc = cctv.r + deltas[dirs[d]][1]*i;
				if(!isIn(nr,nc) || map[nr][nc] == 6) {
					break;
				}
				if(map[nr][nc] >0) {
					continue;
				}
				if(map[nr][nc] == 0) {
					cnt++;
				}
				map[nr][nc] += flag;
			}
		}
		
		return cnt;
	}
	
	private static boolean isIn(int nr, int nc) {
		return 0<=nr && nr<N && 0<= nc && nc<M;
	}
	
	static class CCTV{
		int r, c;
		int type;
		
		public CCTV(int r, int c, int type) {
			super();
			this.r = r;
			this.c = c;
			this.type = type;
		}
		
		
		
	}

}
