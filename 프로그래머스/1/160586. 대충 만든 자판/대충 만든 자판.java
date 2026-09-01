// 문제 설명
    // keymap에 있는거 몇번 눌러서 targets을 만들 수 있냐? (최소한으로 눌러야 함)
// 제한사항
    // keymap의 길이 1이상 100이하
    // keymap의 원소의 길이 1이상 100이하
    // targets의 길이 1이상 100이하
    // targets의 원소의 길이 1이상 100이하
// 브레인스토밍
    // HashMap<Character, Integer> 하나 만들기
    // keymap 원소를 하나씩 돌기
        // 원소가 String이므로 for문 String.length()만큼 charAt()로 뽑으면서 map에 키를 대문자로 value를 원소의 자리로 넣어주기
        // 계속 돌면서 같은 key가 있으면 더 앞에 있는 원소의 자리 넣기
    // 만들어진 HashMap. targets을 targets.length만큼 돌고
        // 또 안에 String만큼 돌면서 key의 value만큼 result에 더해주기
        

import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        List<Integer> list = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(String k : keymap) {
            for(int i=0; i<k.length(); i++) {
                char cur = k.charAt(i);
                map.put(cur ,Math.min(map.getOrDefault(cur, i+1), i+1));
            }
        }
        
        for(int i=0; i<targets.length; i++) {
            int result = 0;
            for(int j=0; j<targets[i].length(); j++) {
                char cur = targets[i].charAt(j);
                if(!map.containsKey(cur)) {
                    result = -1;
                    break;
                } else {
                    result+=map.get(cur);
                }
            }
            list.add(result);
        }
        
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}