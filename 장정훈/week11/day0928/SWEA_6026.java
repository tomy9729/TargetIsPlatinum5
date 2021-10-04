package week12.day0928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_6026 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int M,N;//M은 사용한 종류 개수, N은 비밀번호 길이
	//M개의 자판으로 N자리 비밀번호
	static long result;
	static int MOD = 1000000007;
	static long fac[];
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		init();
		for(int t=1; t<=T; t++) {
			//문제 공식이
			//∑(-1)^i * kCi * (k-i)^n;
			//이게 핵심
			result=0;
			st = new StringTokenizer(br.readLine()," ");
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			result = slove();
			
			sb.append("#"+t+" "+result+"\n");
		}
		System.out.println(sb);
	}

	static void init() {
		fac = new long[101];
		fac[0] = fac[1] = 1;
		for(int i=2; i<fac.length; i++) {
			fac[i] = (fac[i-1]*i) %MOD;
		}
	}
	
	private static long slove() {
		long tot = 0L;
		for(int i=0; i<=M; i++) {
			long l1 = (i%2 == 0 ? 1 : -1);
			long l2 = nCr(i);
			long l3 = pow(M-i,N);
			
			long result = (MOD + l1*(l2*l3)%MOD)%MOD;
			tot = (tot + result)%MOD;
		}
		return tot;
	}
	
	static long nCr(int r) {
		if(r==0) {
			return 1;
		}
		long l1 = fac[M];
		long l2 = pow(fac[M-r], MOD-2);
		long l3 = pow(fac[r], MOD-2);
		long result = ((l1*l2)%MOD*l3)%MOD;
		return result;
	}
	
	static long pow(long a, int b) {
		//a^b
		if(b==1) {
			return a;
		}
		long half = pow(a,b/2);
		if(b%2==0) {
			return (half*half)%MOD;
		}else {
			return ((half*half)%MOD * a /*원래대로라면 a%MOD지만 a가  MOD보다 크지 않다*/)%MOD;
		}
	}
}
