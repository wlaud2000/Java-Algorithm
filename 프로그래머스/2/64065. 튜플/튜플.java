import java.util.*;

class Solution {
    public int[] solution(String s) {
        
        // 1. 파싱
        String[] parts = s.substring(2, s.length() - 2).split("\\},\\{");
        
        List<int[]> sets = new ArrayList<>();
        
        for(String part : parts) {
            String[] nums = part.split(",");
            int[] set = new int[nums.length];
            for(int i=0; i<nums.length; i++) {
                set[i] = Integer.parseInt(nums[i]);
            }
            sets.add(set);
        }
        
        // 2. 오름차순 정렬
        sets.sort(Comparator.comparingInt(a -> a.length));
        
        // 3. 새로 등장하는 원소만 담기
        List<Integer> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        
        for(int[] set : sets) {
            for(int num : set) {
                if(seen.add(num)) {
                    result.add(num);
                }
            }
        }
         
        // 4. int[]로 제출
        int[] answer = new int[result.size()];
        for (int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        
        return answer;
    }
}