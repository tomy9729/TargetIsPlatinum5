package week6.day0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1931_test {

	static class Meeting implements Comparable<Meeting>{//회의 하나하나를 미팅으로 두겠다.
		int start, end;

		public Meeting(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override//반환 값이 음수면 비교하는 대상보다 내가 작다. 0 이면 둘이 나와 비교하는 값이 같다. 양수면 내가 비교하는 대상보다 크다
		//내림차순으로 하고 싶을 때는 위랑 반대로 반환값을 준다.
		public int compareTo(Meeting o) {
			int value = this.end - o.end;
			if(value !=0) {
				return value;
			}//종료시간을 비교한 뒤. 종료시간이 같으면  0이 나오기 때문에 
			//시작시간을 비교한다.
			return this.start-o.start;
		}

		@Override
		public String toString() {
			return "Meeting [start=" + start + ", end=" + end + "]";
		}
		
		
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine());
		Meeting[] meetings = new Meeting[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));	
		}
//		for(Meeting meeting : getSchedule(meetings)) {
//			System.out.println(meeting);
//		}
		ArrayList<Meeting> l = getSchedule(meetings);
		System.out.println(l.size());
	}
	static ArrayList<Meeting> getSchedule(Meeting[] meetings){
		ArrayList<Meeting> list = new ArrayList<>();
		Arrays.sort(meetings);//종료시간 기준 오름차순 정렬
		list.add(meetings[0]);//첫 회의 추가 종료시간이 가장 짧을 것.
		
		for(int i=1,size=meetings.length; i<size; i++) {
			if(list.get(list.size()-1).end<=meetings[i].start) {//이전 회의의 종료시간과 지금 회의의 시작시간을 비교
				list.add(meetings[i]);
			}
		}
		return list;
	}

}
