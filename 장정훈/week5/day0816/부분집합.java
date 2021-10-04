package week6.day0816;

public class 부분집합 {
	
	static int[] num = {1,2,3,4};
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		powerSetDupPer(num.length, new boolean[num.length]);//n개의 요소로 만들 수 있는 경우의 수
						//4							4
		System.out.println(sb.toString());
	}
	static void powerSetDupPer(int toChoose, boolean[] choosed) {
        if (toChoose == 0) {//기저조건!
        	print(choosed);
        	return;
        }
            choosed[toChoose - 1] = true; //처음에는 다 true로 진행하고
            powerSetDupPer(toChoose - 1, choosed); //true로 넣어준 다음에
            choosed[toChoose - 1] = false; //다음에는 false로 바꿔서 진행하면 모든 경우의 수를 볼 수 있겠다!
            powerSetDupPer(toChoose - 1, choosed);
    }
	private static void print(boolean[] choosed) {
		for(int i=0; i<choosed.length; i++) {
			if(!choosed[i]) continue;
			
			sb.append(num[i]+" ");
		}
		sb.append("\n");
		
	}
}
