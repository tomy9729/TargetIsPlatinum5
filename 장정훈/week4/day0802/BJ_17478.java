package week4.day0802;

import java.util.Scanner;

public class BJ_17478 {
	
	public static String[] strAry = {
			"\"재귀함수가 뭔가요?\"",
			"\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.",
			"마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.",
			"그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"",
			"라고 답변하였지."
	};
	public static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		print(0);
	}
	
	public static void print(int x) {
		System.out.println(printV(x)+strAry[0]);
		
		if(x==N) {
			System.out.println(printV(x)+"\"재귀함수는 자기 자신을 호출하는 함수라네\"");//""이거 빠짐...
			System.out.println(printV(x)+strAry[4]);
			return;
		}else {
			System.out.println(printV(x)+strAry[1]);
			System.out.println(printV(x)+strAry[2]);
			System.out.println(printV(x)+strAry[3]);
		}
		
		print(x+1);
		System.out.println(printV(x)+strAry[4]);
		
	}
	public static String printV(int x) {
		String str = "";
		if(x>0) {
			str = "____"+printV(x-1);
		}
		return str;
	}
}
