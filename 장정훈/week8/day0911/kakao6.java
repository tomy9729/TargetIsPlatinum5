package week9.day0911;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class kakao6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		kakao6 k6 = new kakao6();
		int[][] board = {{5,5,5,5,5},
						{5,5,5,5,5},
						{5,5,5,5,5},
						{5,5,5,5,5}};
		int[][] skill = {{1,0,0,3,4,4},
						{1,2,0,2,3,2},
						{2,1,0,3,1,2},
						{1,0,1,3,3,1}};
		int answer = k6.solution(board,skill);
		System.out.println(answer);
	}


	private int solution(int[][] board, int[][] skill) {
		int answer=0;
		int cnt=0;
		for(int i=0; i<skill.length; i++) {
		
			for(int r=skill[i][1]; r<=skill[i][3]; r++) {
				for(int c=skill[i][2]; c<=skill[i][4]; c++) {
					cnt++;
					if(skill[i][0] ==1) {
						board[r][c] -= skill[i][5];
					}else if(skill[i][0] ==2) {
						board[r][c] += skill[i][5];
					}
				}
			}
			
			
		}
		
		for(int i=0; i<board.length; i++) {
			int[] ary = board[i];
			Arrays.sort(ary);
			for(int j=ary.length-1; j>=0; j--) {
				if(ary[j]<1) {
					break;
				}
				answer++;
				cnt++;
			}
		}
		return answer;
	}
	private int solution2(int[][] board, int[][] skill) {
		int answer=0;
		int cnt=0;
		List<wall> list = new ArrayList<>();
		int Rsize = board.length;
		int Csize = board[0].length;
		for(int r=0; r<board.length; r++) {
			for(int c=0; c<Csize; c++) {
				list.add(new wall(r,c,board[r][c]));
				cnt++;
			}
		}
		for(int i=0; i<skill.length; i++) {
			int rs=skill[i][3]-skill[i][1];
			int cs=skill[i][4]-skill[i][2];
			for(int r=skill[i][1]; r<=skill[i][3]; r++) {
				for(int c=skill[i][2]; c<=skill[i][4]; c++) {
					cnt++;
					if(skill[i][0] ==1) {
						list.get(r*rs+c).hp -= skill[i][5];
					}else if(skill[i][0] ==2) {
						list.get(r*rs+c).hp += skill[i][5];
					}
				}
			}
		}
		Collections.sort(list);
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).hp<1) break;
			answer++;
			cnt++;
		}
		System.out.println(cnt);
		return answer;
	}
	public class wall implements Comparable<wall>{
		int r;
		int c;
		int hp;
		
		public wall(int r, int c, int hp) {
			super();
			this.r = r;
			this.c = c;
			this.hp = hp;
		}

		@Override
		public int compareTo(wall o) {
			return Integer.compare(o.hp, this.hp);
		}
		
	}
}
