import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int cntP = 0;
        int cntY = 0;
        
        String sample = s.toLowerCase();
        
        for (int i=0; i<s.length(); i++) {
            char cur = sample.charAt(i);
            if (cur == 'p') {
                cntP++;
            } else if (cur == 'y') {
                cntY++;
            }
        }
        
        if(cntP == cntY) {
            answer = true;
        } else {
            answer = false;
        }
        
        return answer;
    }
}