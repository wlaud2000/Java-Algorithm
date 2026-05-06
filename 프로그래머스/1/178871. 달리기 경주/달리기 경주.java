import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> rankMap = new HashMap<>();
        
        for (int i=0; i<players.length; i++) {
            rankMap.put(players[i], i);
        }
        
        for (String name: callings) {
            
            int rank = rankMap.get(name);
            String frontName = players[rank-1];
            
            // 배열 swap
            players[rank-1]=name;
            players[rank]=frontName;
            
            // rankMap swap
            rankMap.put(name, rankMap.get(frontName));
            rankMap.put(frontName, rank);
        }
        return players;
    }
}