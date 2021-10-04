package week12.day0929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16134 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static long[] fac;
	static int MOD = 1000000007;
	static int N, R;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		fac = new long[N+1];
		fac[0] = 1;
		fac[1] = 1;
		for(int i=2; i<fac.length; i++) {
			fac[i] = (fac[i-1]*i)%MOD;
		}
		
		
		System.out.println(nCr());
	}

	private static long nCr() {
		if(R==0 || R==N) {
			return 1;
		}
		else if(R==1 || R ==N-1) {
			return N;
		}
		long l1 = fac[N];
		long l2 = pow(fac[N-R],MOD-2);
		long l3 = pow(fac[R],MOD-2);
		long result = (l1%MOD *l2%MOD *l3%MOD)%MOD;
		
		return result;
	}

	private static long pow(long a, int n) {
		if(n==1) {
			return a;
		}
		long half = pow(a,n/2);
		if(n%2==0) {
			return (half*half)%MOD;
		}else {
			return ((half*half)%MOD*a)%MOD;
		}
	}
}
