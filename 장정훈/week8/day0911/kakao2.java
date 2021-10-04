package week9.day0911;

public class kakao2 {

	public static void main(String[] args) {
		kakao2 k2 = new kakao2();
//		int n = 1;//110011;
//		int k = 10;//10;
//		for(int n=700000; n<=1000000; n++) {
//			for(int k=3; k<=10; k++) {
//				System.out.println(n+"=="+k);
//				int answer = k2.solution(n,k);
//			}
//		}
		int answer = k2.solution(700005,4);
		System.out.println(answer);
	}

	private int solution(int n, int k) {
		
		String str = conversion(n,k);
		String extra = "";
		int cnt =0;
//		System.out.println(str);
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)!='0') {
				extra+=str.charAt(i);
			}
			if(str.charAt(i)=='0'||i==str.length()-1) {
				
				if(extra.equals("")||extra.equals("1")) {
					extra="";
					continue;
				}else {
					
					long num = Long.parseLong(extra);
					if(num!=1 && primeCheck(num)) {
						cnt++;
					}
					extra="";
					continue;
				}
			}
		}
		
		
		return cnt;
	}

	private boolean primeCheck(Long num) {
		boolean flag = true;
		if(num==2) {
			return true;
		}
		if(num%2==0) {
			return false;
		}
		for(int i=3; i<num; i+=2) {
			if(num%i==0) {
				flag=false;
			}
		}
		return flag;
	}

	private String conversion(int n, int k) {
		StringBuilder sb = new StringBuilder();
		if(k==10) {
			sb.append(n);
		}else {
			while(n>0) {
				sb.append(n%k);
				n = n/k;
			}
			sb.reverse();
		}
		return sb.toString();
	}

}
