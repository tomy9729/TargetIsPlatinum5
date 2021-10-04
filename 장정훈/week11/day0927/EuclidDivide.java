package week12.day0927;

public class EuclidDivide {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		eeuc(1071,1029);
		
	}

	private static void eeuc(int a, int b) {
		
		int r0 = a;
		int r1 = b;
		int s0 = 1;
		int s1 = 0;
		int t0 = 0;
		int t1 = 1;
		int temp = 0;
		int q=0;
		while(r1>0) {
			q=r0/r1;
			temp=r0;
			r0=r1;
			r1 = temp - r1 * 1;//42 = 1071 - 1029 * (1071/1029)
			temp = s0;
			s0 = s1;
			s1 = temp - s1 * q;
			temp = t0;
			t0 = t1;
			t1 = temp - t1 * 1;
		}
		System.out.printf("%d*%d+%d*%d=%d",a,s0,b,t0,a*s0+b*t0);
	}

}
