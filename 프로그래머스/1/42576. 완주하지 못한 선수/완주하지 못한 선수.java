import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        
        HashMap<String, Integer> map = new HashMap<>();
        
        // participant 순회하면서 등장 횟수 카운트
        for (String p: participant) {
            map.put(p, map.getOrDefault(p,0) + 1); // key가 map에 있으면 그 value를 없으면 0을 줌
        }
        
        // completion 순회하면서 카운트 차감
        for (String c: completion) {
            map.put(c, map.get(c) - 1);
        }
        
        for (String key: map.keySet()) { // map.keySet()은 HashMap에 있는 모든 key를 Set으로 반환해주는 메서드
            if (map.get(key) > 0) {
                return key;
            }
        }
        
        return "";
    }
}