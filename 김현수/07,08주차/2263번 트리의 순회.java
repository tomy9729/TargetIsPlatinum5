//2263번 트리의 순회.java
package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 트리의_순회_2263  {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
       
    static int[] inOrder;
    static int[] postOrder;
    static int[] inOrderP;
    public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		
		inOrder = new int[N+1];
		postOrder = new int[N+1];
		inOrderP = new int[N+1];
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++) {
			inOrder[i]=Integer.parseInt(st.nextToken());
			inOrderP[inOrder[i]]=i;
		}
		st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<N;i++)postOrder[i]=Integer.parseInt(st.nextToken());
		
		preOrder(0,N,0,N);
	}
    public static void preOrder(int startI, int endI, int startP, int endP) {
    	if(startI >= endI || startP >= endP)return;
    	int p = postOrder[endP-1];
    	int index=inOrderP[p];
    	System.out.print(p+" "); //부모 출력
    	preOrder(startI,index,startP,startP+(index-startI));
    	preOrder(index+1,endI,index-startI+startP,endP-1);
    }
}
