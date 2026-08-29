import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        int idx = 0;
        
        for (int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            idx++;
            
            // 현재 문자가 공백일 경우
            if(cur == ' ') {
                idx = 0;
                sb.append(' ');
            } 
            // 현재 문자가 공백이 아닐 경우
            else {
                // 위치가 짝수면 소문자
                if(idx%2 == 0) {
                    sb.append(Character.toLowerCase(cur));
                } 
                // 위치가 홀수면 대문자
                else {
                    sb.append(Character.toUpperCase(cur));
                }
            }
        }
        
        return sb.toString();
    }
}