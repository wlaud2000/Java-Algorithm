import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        ArrayList<Integer> kScore = new ArrayList<>();
        
        for(int i=0; i<score.length; i++) {
	        kScore.add(score[i]);
	        Collections.sort(kScore);
	        
	        if (kScore.size() > k) {
						kScore.remove(0);
		        Collections.sort(kScore);
	        }
	        
	        answer[i] = kScore.get(0);
        }
        
        
        
        return answer;
    }
}