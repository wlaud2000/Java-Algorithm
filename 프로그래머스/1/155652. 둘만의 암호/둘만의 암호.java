// [문제 요약]
//     알파벳 a~z에서 skip에 들어간걸 뺴고 다 배열에 넣어주기
//     그리고 인덱스 5 더해서 하기

import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        HashSet<Character> skipSet = new HashSet<>();
        HashMap<Character, Integer> alphaMap = new HashMap<>();
        HashMap<Integer, Character> idxMap = new HashMap<>();
        
        StringBuilder sb = new StringBuilder();
        
        
        for(int i=0; i<skip.length(); i++) {
            skipSet.add(skip.charAt(i));
        }
        
        int cnt = 0;
        for(int i=0; i<26; i++) {
            char cur = (char)(97 + i);
            if(!skipSet.contains(cur)) {
                alphaMap.put(cur, cnt);
                idxMap.put(cnt, cur);
                cnt++;
            }
        }
        
        for(int i=0; i<s.length(); i++) {
            int idx = alphaMap.get(s.charAt(i));
            int targetIdx = (idx + index)%idxMap.size();
            char target = idxMap.get(targetIdx);
            
            sb.append(target);
        }
        
        return sb.toString();
    }
}