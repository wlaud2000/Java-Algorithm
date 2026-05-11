import java.util.*;

class Solution {
	public int[] solution(String[] id_list, String[] report, int k) {
		// id_list 인덱스 맵
		HashMap<String, Integer> indexMap = new HashMap<>();
		for (int i=0; i<id_list.length; i++) {
			indexMap.put(id_list[i], i);
		}

		// 중복 신고 제거
		HashSet<String> reportSet = new HashSet<>(Arrays.asList(report));
		
		// 신고당한 횟수 세기
		HashMap<String, Integer> countMap = new HashMap<>();
		for (String r: reportSet) {
			String reported = r.split(" ")[1];
			countMap.put(reported, countMap.getOrDefault(reported, 0) + 1);
		}
		
		// 메일 횟수 계산
		int[] answer = new int[id_list.length];
		for (String r: reportSet) {
			String reporter = r.split(" ")[0];
			String reported = r.split(" ")[1];
			if (countMap.getOrDefault(reported, 0) >= k) {
				answer[indexMap.get(reporter)]++;
			}
		}
		return answer;
	}
}