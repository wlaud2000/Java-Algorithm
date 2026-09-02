// 문제설명
    // number에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 수(자리 옮기지 말고 제거만)
// 제한조건
    // number는 2자리 이상, 1,000,000 자리 이하 숫자(String임)
    // k는 1 이상 number의 자릿수 미만인 자연수
// 이 문제는 그리디다
    // 숫자는 앞자리가 클수록 무조건 큼 -> 앞자리를 최대한 크게 만드는 선택은 후회 할 일 없음
    // -> 지금 당장 제일 좋은 선택이 전체적으로도 제일 좋은 선택이 됨.
// 지우는 판단 기준
    // 값이 작은걸 지우는게 아님
    // 내가 방금 넣은 값(앞자리)보다 지금 넣을 값이 작으면 그냥 넣고, 크면 교체해준다.

import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<number.length(); i++) {
            char cur = number.charAt(i);
            
            while(!stack.isEmpty() && cnt < k && stack.peek() < cur) {
                stack.pop();
                cnt++;
            }
            stack.push(cur);
        }
        
        while(cnt < k) {
            stack.pop();
            cnt++;
        }
        
        while(!stack.isEmpty()) {
            char top = stack.pop();
            sb.insert(0, top);
        }
        
        return sb.toString();
    }
}