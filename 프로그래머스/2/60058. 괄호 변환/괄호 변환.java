import java.util.*;

class Solution {
    // u와 v를 나누는 기준 제공 함수
    private int findSplit(String p) {
        int count = 0;
        
        for (int i=0; i<p.length(); i++) {
            if(p.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
            
            if(count == 0) return i + 1;
        }
        return p.length(); // 실제로는 실행되지 않는 코드(p는 항상 균형잡혀 있기 때문)
    }
    
    // u가 (로 시작하는지 확인하는 함수((로 시작하면 항상 올바른 괄호이기 때문에)
    private boolean isCorrect(String u) {
        return u.charAt(0) == '(';
    }
    
    // u가 올바른 문자열이 아니라면 실행 할 함수
    private String flip(String u) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=1; i<u.length()-1; i++) { // 첫번째와 마지막 문자 제거
            sb.append(u.charAt(i) == '(' ? ')' : '(');
        }
        
        return sb.toString();
    }
    
    public String solution(String p) {
        if(p.isEmpty()) {
            return "";
        }
        
        int split = findSplit(p);
        
        String u = p.substring(0,split);
        String v = p.substring(split);
        
        if(isCorrect(u)) {
            return u + solution(v);
        } else {
            return "(" + solution(v) + ")" + flip(u);
        }
        
    }
}