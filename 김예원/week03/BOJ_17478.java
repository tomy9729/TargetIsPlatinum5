package algol;

import java.util.Scanner;

public class Recursion_17478 {
static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		Recursion(0);
		
		
	}
	public static void Recursion(int n) {
		
		String Q1 = "\"재귀함수가 뭔가요?\"";
		String[] A = new String[3];
		A[0] = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
		A[1] = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
		A[2] = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
		String add = "____";
		
		
		StringBuilder sb = null;
		
		
		for(int i=0;i<n;i++) {
			System.out.print("____");
		}
		System.out.println("\"재귀함수가 뭔가요?\"");
		
		if(n < N) {
			for(int j=0;j<3;j++) {
				sb = new StringBuilder();
				for(int i=0;i<n;i++) {
					sb.append(add);
				}
				System.out.println(sb.append(A[j]));
			}		
		}
		else if(n==N) {
			for(int i=0;i<N;i++) {
				System.out.print("____");
			}
			System.out.println("\"재귀함수는 자기 자신을 호출하는 함수라네\"");
			for(int i=0;i<N;i++) {
				System.out.print("____");
			}
			System.out.println("라고 답변하였지.");
			return;
		}
		
		Recursion(++n);
		for(int i=0;i<n-1;i++) {
			System.out.print("____");
		}
		System.out.println("라고 답변하였지.");
		return;
		
	}
	

}
