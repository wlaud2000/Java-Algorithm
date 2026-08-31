// x,y 공통으로 나타나는 정수k(0~9)들을 이용하여 만들 수 있는 가장 큰 정수 = 두 수의 짝꿍
    // 짝꿍이 존재하지 않으면, 짝꿍은 -1

// X를 순회하면서 HashMap에 key: Integer, value : Integer로 key가 나온 횟수만큼 value를 +1 해줌
// Y를 순회하면서 HashMap에서 key가 나온 횟수만큼 value를 -1 해주고 result에 담음
    // 여기서 value가 0이되면 더이상 뺼 수 없음
// result에 담긴 원소를 내림차순해주면 가장 큰 정수가 됨.

import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<X.length(); i++) {
            map.put((int)X.charAt(i), map.getOrDefault((int)X.charAt(i), 0) + 1);
        }
        
        for(int i=0; i<Y.length(); i++) {
            int key = (int)Y.charAt(i);
            if(!map.containsKey(key)) {
                continue;
            } else {
                // value가 0이면 continue
                if(map.get(key) == 0) {
                    continue;
                } else {
                    // value가 0이 아니면 value -1하고 result에 append
                    map.put(key, map.get(key) - 1);
                    sb.append((char)key);
                }
            }
        }
        
        String answer = "";
        
        String str = sb.toString();
        if(str.isEmpty()) {
            answer = "-1";
        } else {
           char[] arr = str.toCharArray();
            Arrays.sort(arr);                                        // 오름차순
            sb = new StringBuilder(new String(arr)).reverse();       // 뒤집어서 내림차순

            answer = sb.charAt(0) == '0' ? "0" : sb.toString();
        }
        
        return answer;
    }
}