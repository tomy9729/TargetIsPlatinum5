package week3.day0726;

public class BJ_4673 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ary = new int[10001]; //1부터 진행할 거지만, 구분짓기 쉽게
		for(int i=1; i<10001; i++) {
			if(i<10) {
				if(i+(i%10)<=10000) {
					ary[i+(i%10)]=1;
				}
			}else if(i<100) {
				if(i+(i/10)+(i%10)<=10000) {
					ary[i+(i/10)+(i%10)] = 1;
				}
			}else if(i<1000) {
				if(i+(i/100)+((i/10)%10)+(i%10)<=10000) {
					ary[i+(i/100)+((i/10)%10)+(i%10)] = 1;
				}
			}else if(i<10000) {
				if(i+(i/1000)+((i/100)%10)+((i/10)%10)+(i%10)<=10000) {
					ary[i+(i/1000)+((i/100)%10)+((i/10)%10)+(i%10)]=1;
				}
			}else {
				if(i+(i/10000)+((i/1000)%10)+((i/100)%10)+((i/10)%10)+(i%10)<=10000) {
					ary[i+(i/10000)+((i/1000)%10)+((i/100)%10)+((i/10)%10)+(i%10)]=1;
				}
			}
			
			
		}
		for(int i=1; i<10001; i++) {
			if(ary[i]!=1) {
				System.out.println(i);
			}
		}
	}

}
