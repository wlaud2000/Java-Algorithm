// 문제 설명
    // 괄호쌍이 올바른지 찾으셈요
// 브레인 스토밍
    // 처음 문자가 ')'면 무조건 false임
    // Stack을 만들기
    // for문을 s 길이만큼 돌기
        // 스택에 item을 넣기 전에 stack의 top을 봄
            // 만약 stack이 비어있으면 push함
            // 만약 top과 item의 짝이 맞으면 top을 pop함
            // 만약 top과 짝이 맞지 않으면 push함.
    // for문을 다 돌았을 때 stack이 비어있으면 true, 비어있지 않으면 false

import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        boolean answer = true;
        
        for(int i=0; i<s.length(); i++) {
            if(stack.isEmpty()) {
                if(s.charAt(i) == ')') { // 중요
                    return false;
                }
                stack.push(s.charAt(i));
            } else if(stack.peek() == s.charAt(i)) {
                stack.push(s.charAt(i));
            } else {
                stack.pop();
            }
        }
        
        if(stack.isEmpty()) {
            answer = true;
        } else {
            answer = false;
        }

        return answer;
    }
}