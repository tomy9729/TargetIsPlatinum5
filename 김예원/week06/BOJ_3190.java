package week06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;



class Move{
	int r, c;

	public Move(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}

	@Override
	public String toString() {
		return "Move [r=" + r + ", c=" + c + "]";
	}

	
	// 꼬리와 닿았는지 확인하려면 queue.contains()를 사용
	// 객체가 데이터 상으로 동일한 객체인지 확인하기 위해서는 객체  hashCode&equals 오버라이드 필요
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + c;
		result = prime * result + r;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Move other = (Move) obj;
		if (c != other.c)
			return false;
		if (r != other.r)
			return false;
		return true;
	}
	
	
}
public class BOJ_3190 {
	static int N, K, L;
	static int[][] deltas = {{0,1},{1,0},{0,-1},{-1,0}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 보드의 크기
		N = Integer.parseInt(br.readLine());
		// 사과의 개수
		K = Integer.parseInt(br.readLine());
		
		int R = 1; int C = 1;
		int count = 0;
		int[][] board = new int[N+1][N+1];
		for(int i=0;i<K;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]++;
		}
		
		// 첫 길이
		board[1][1] = -1;
		
		L = Integer.parseInt(br.readLine());
		
		// 1:우  2:하  3:좌 4:상 -> 움직이는 방향  
		Deque<Integer> deq = new ArrayDeque<>();
		// 뱀의 길이에 따른 index를 덱으로 저장
		// 이유 -> 머리를 앞에서 넣어주고, 뒤에서 꼬리를 찾기 위해서 
		Deque<Move> snake = new ArrayDeque<>();
		
		snake.offer(new Move(1,1));
		for(int i=0;i<4;i++) {			
			deq.offer(i);
		}
		
		
		int sec = 0;
		int[] checkPoint = new int[L];
		String s ="";
		for(int i=0;i<L;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x =Integer.parseInt(st.nextToken());
			checkPoint[i]=x;
			s += st.nextToken();
		}
		
		
		int index = 0;
		int dir = 0;
		out : while(true) {
			dir = deq.peekFirst();

			count++;
			R += deltas[dir][0]; C += deltas[dir][1]; 

			
			
			// 벽에 닿으면 끝
			if(!(R>0&&R<=N && C>0&&C<=N)) break out;
			// 몸에 닿으면 끝
			else if(snake.contains(new Move(R,C))) break out;
			
			
			
			// 위 두 상황이 아니라면 머리를 늘린다
			snake.offerFirst(new Move(R,C));
			
			
			
			// 사과라면 
			if(board[R][C] == 1) board[R][C]=0;
			//사과가 아니라면 
			else snake.pollLast();
				
				
			
				

			// 방향 바꿀지 검사
			if(index<L && count==checkPoint[index]) {
				if(s.charAt(index)=='L') {
					// 뒤에꺼 꺼내서 앞에 넣기
					deq.offerFirst(deq.pollLast());
				}
				else {
					// 뒤에꺼 꺼내서 앞에 넣기
					deq.offerLast(deq.pollFirst());
				}
				index++;
			}
			
		}
		
		System.out.println(count);
	}
	
	
}
