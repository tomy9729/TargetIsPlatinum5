package week7.day0825;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1592 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, L;//영식이 친구들, 던질 횟수, 옆칸놈.
	static int[] Person;
	static int cnt;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		Person = new int[N+1];
		cnt = 0;
		play(1);
		
		System.out.println(cnt);
	}

	private static void play(int nowPerson) {
		Person[nowPerson]++;
		if(Person[nowPerson] == M) {
			return;
		}
		cnt++;
		int next = nowPerson;//그냥 초기화
		if(Person[nowPerson]%2==0) {//짝수
			
			for(int i=0; i<L; i++) {
				if(next == 1) {
					next = N;
				}else {
					next--;
				}
			}
			
			
		}else if(Person[nowPerson]%2 != 0){//홀수
			
			for(int i=0; i<L; i++) {
				if(next == N) {
					next = 1;
				}else {
					next++;
				}
				
			}
			
		}
		
		play(next);
		
	}

}
