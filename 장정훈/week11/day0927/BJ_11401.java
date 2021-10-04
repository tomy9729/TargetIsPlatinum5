package week12.day0927;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11401 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static long[] DP;
	static int mod = 1000000007;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		DP = new long[N+1];
		DP[0] = 1;
		DP[1] = 1;
		init();	
		System.out.println(nCr(N,K));
	}

	static void init() {
		
		for(int i=2; i<DP.length; i++) {
			DP[i] = (DP[i-1]*i) %mod;
		}
	}
	
	static long nCr(int N, int r) {
		if(r==0) {
			return 1;
		}
		long l1 = DP[N];
		long l2 = pow(DP[N-r], mod-2);
		long l3 = pow(DP[r], mod-2);
		long result = ((l1*l2)%mod*l3)%mod;
		return result;
	}
	
	static long pow(long a, int b) {
		//a^b
		if(b==1) {
			return a;
		}
		long half = pow(a,b/2);
		if(b%2==0) {
			return (half*half)%mod;
		}else {
			return ((half*half)%mod * a /*원래대로라면 a%MOD지만 a가  MOD보다 크지 않다*/)%mod;
		}
	}

}
