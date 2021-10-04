package week9.day0911;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class kakao3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		kakao3 k3 = new kakao3();
		int[] fees = {180, 5000, 10, 600};//기본시간, 기본요금, 
		String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", 
							"07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", 
							"19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
		int[] answer = k3.solution(fees, records);
		System.out.println(Arrays.toString(answer));
	}

	private int[] solution(int[] fees, String[] records) {
		StringTokenizer st;
		int[] answer;
		TreeSet<String> set = new TreeSet<>();
		Map<String, Queue<String>> map = new HashMap<>();
		String[][] reco = new String[records.length][3];
		for(int i=0; i<records.length; i++) {
			st = new StringTokenizer(records[i]," ");
			String time = st.nextToken();
			String number = st.nextToken();
			String status = st.nextToken();
			set.add(number);
			reco[i][0] = time;
			reco[i][1] = number;
			reco[i][2] = status;
			Queue<String> q;
			if(map.get(number)!=null) {
				q = map.get(number);
			}
			else{
				q = new LinkedList<>();
			}
			q.add(time);
			map.put(number, q);
		}
		List<String> list = new ArrayList<String>(set);
		Collections.sort(list);
		answer = new int[list.size()];
		for(int i=0; i<map.size(); i++) {
			Queue<String> q = map.get(list.get(i));
			if(q.size()%2!=0) {
				q.add("23:59");
			}
			int cnt =0;
			while(!q.isEmpty()) {
				String inTime = q.poll();
				String outTime = q.poll();
				int in = 0;
				int out = 0;
				st = new StringTokenizer(inTime,":");
				String inTimeH = st.nextToken();
				String inTimeM = st.nextToken();
				in = Integer.parseInt(inTimeM)+(60*Integer.parseInt(inTimeH));
				st = new StringTokenizer(outTime,":");
				String outTimeH = st.nextToken();
				String outTimeM = st.nextToken();
				out = Integer.parseInt(outTimeM)+(60*Integer.parseInt(outTimeH));
				cnt += (out-in);
			}
			System.out.println(cnt);
			if(cnt<=fees[0]) {
				answer[i] = fees[1];
			}else {
				answer[i] = (int)(fees[1] + ( Math.ceil((cnt-fees[0])/(fees[2]*1.0)))*fees[3]);
			}
		}
		System.out.println(set);
		
		return answer;
	}

}
