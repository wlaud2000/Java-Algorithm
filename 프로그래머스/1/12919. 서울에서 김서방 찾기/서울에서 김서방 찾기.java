// 문제 설명
    // 배열 seoul의 원소에서 Kim을 찾아서 그 자리랑 출력

import java.util.*;

class Solution {
    public String solution(String[] seoul) {
        
        String answer = "";
        
        for(int i=0; i<seoul.length; i++) {
            if(seoul[i].equals("Kim")) {
                answer = "김서방은 " + i + "에 있다";
            }
        }
        return answer;
    }
}