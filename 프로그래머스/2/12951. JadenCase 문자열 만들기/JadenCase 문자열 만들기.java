// 브레인스토밍
    // String 원소의 length()만큼 반복문
        // 하나씩 보면서 스택에 담기
        // 만약 stack이 isEmpty면
            // cur이 숫자거나 대문자면
                // 그냥 넣기
            // 소문자면
                // 대문자로 변경 후 넣기
        // isEmpty가 아니면
            // 만약 peek()이 대문자면 || 만약 peek()이 소문자면
                // 만약 cur이 소문자면 || 만약 cur이 공백이면
                    // 그냥 넣기
                // 만약 cur이 대문자면
                    // 소문자로 변경 후 넣기
            // 만약 peek()이 공백이면
                // 만약 cur이 소문자면
                    // 대문자로 변경 후 넣기
                // 만약 cur이 대문자면
                    // 그냥 넣기
            // 만약 peek()이 숫자면
                // 만약 cur이 소문자면
                    // 그냥 넣기
                // 만약 cur이 대문자면
                    // 소문자로 변경 후 넣기

import java.util.*;


class Solution {
    public String solution(String s) {
        
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        
        for(int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            
            // 만약 stack이 isEmpty면
            if(stack.isEmpty()) {
                // cur이 숫자거나 대문자면
                if(Character.isDigit(cur) || Character.isUpperCase(cur)) {
                    // 그냥 넣기
                    stack.push(cur);
                } else if(Character.isLowerCase(cur)) { // 소문자면
                    // 대문자로 변경 후 넣기
                    stack.push(Character.toUpperCase(cur));
                }
            } else if(!stack.isEmpty()) { // isEmpty가 아니면
                char pre = stack.peek();
                
                // 만약 peek()이 대문자면 || 만약 peek()이 소문자면
                if(Character.isUpperCase(pre) || Character.isLowerCase(pre)) {
                    // 만약 cur이 소문자면 || 만약 cur이 공백이면
                    if(Character.isLowerCase(cur) || cur == ' ') {
                        // 그냥 넣기
                        stack.push(cur);
                    }
                    // 만약 cur이 대문자면
                    else if(Character.isUpperCase(cur)) {
                        // 소문자로 변경 후 넣기
                        stack.push(Character.toLowerCase(cur));
                    }
                        
                } else if(pre == ' ') { // 만약 peek()이 공백이면
                    // 만약 cur이 소문자면
                    if(Character.isLowerCase(cur)) {
                        // 대문자로 변경 후 넣기
                        stack.push(Character.toUpperCase(cur));
                    }
                    // 만약 cur이 대문자면 || 만약 cur이 숫자면 || 만약 cur이 공백이면
                    else if(Character.isUpperCase(cur) || Character.isDigit(cur) || cur == ' ') {
                        // 그냥 넣기
                        stack.push(cur);
                    }
                } 
                // 만약 peek()이 숫자면
                else if(Character.isDigit(pre)) {
                    // 만약 cur이 소문자면
                    if(Character.isLowerCase(cur)) {
                        // 그냥 넣기
                        stack.push(cur);
                    }
                    // 만약 cur이 대문자면
                    else if(Character.isUpperCase(cur)) {
                        // 소문자로 변경 후 넣기
                        stack.push(Character.toLowerCase(cur));
                    }
                }
            }
            
            
            
        }
        
        int size = stack.size();
        for(int i=0; i<size; i++) {
            char item = stack.pop();
            sb.insert(0, item);
        }
        
        return sb.toString();
    }
}