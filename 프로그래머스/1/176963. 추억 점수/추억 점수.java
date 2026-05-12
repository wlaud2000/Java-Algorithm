import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        
        HashMap<String, Integer> scoreMap = new HashMap<>();
        for (int i=0; i<name.length; i++) {
            scoreMap.put(name[i], yearning[i]); // ("may", 5) ("kein", 10) ("kain", 1) ("radi", 3)
        }
        
        int[] answer = new int[photo.length];
        
        for (int i=0; i<photo.length; i++) {
            for (int j=0; j<photo[i].length; j++) {
                answer[i] = answer[i] + scoreMap.getOrDefault(photo[i][j], 0);
            }
        }
        return answer;
    }
}