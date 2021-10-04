package week9.day0911;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class kakao1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		kakao1 k1 = new kakao1();
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k=2;
		int[] answer = k1.solution(id_list,report,k);
		System.out.println(Arrays.toString(answer));
	}

	private int[] solution(String[] id_list, String[] report, int k) {
		StringTokenizer st;
		int[] answer = new int[id_list.length];//정지 됐음을 안내하는 배열
		
		Set<String> set = new HashSet<>();
		for(int i=0; i<report.length; i++) {
			set.add(report[i]);
		}
		Iterator<String> itSet = set.iterator();
		
		String[][] fromTo = new String[set.size()][2];
		for(int i=0; i<set.size(); i++) {
			st = new StringTokenizer(itSet.next()," ");
			String ob = st.nextToken();
			String str = st.nextToken();
			fromTo[i][0] = ob;
			fromTo[i][1] = str;
		}
		HashMap<String, Integer> check = new HashMap<>();
		for(int i=0; i<fromTo.length; i++) {
			if(check.get(fromTo[i][1])!=null) {
				int cnt = check.get(fromTo[i][1]);
				cnt++;
				check.put(fromTo[i][1], cnt);
			}else {
				check.put(fromTo[i][1], 1);				
			}
			
		}
		for(int i=0; i<fromTo.length; i++) {
			if(check.get(fromTo[i][1])>=k) {
				for(int j=0; j<id_list.length; j++) {
					
					if(fromTo[i][0].equals(id_list[j])) {
						
						answer[j]++;
					}
				}
			}
		}
		return answer;
	}

}
