import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Arrays.sort(score);
        //[1,1,1,2,2,3,3]으로 정렬
        // k = 3, m = 4, score.length = 7
        
        for (int i=1; score.length - (i*m) >=0; i++) {
            int idx = score.length - (i*m);
            
            answer = answer + score[idx] * m;
        }
        
        
        return answer;
    }
}