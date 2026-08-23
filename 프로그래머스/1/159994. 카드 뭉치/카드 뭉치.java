import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        Deque<String> c1 = new ArrayDeque<>(Arrays.asList(cards1));
        Deque<String> c2 = new ArrayDeque<>(Arrays.asList(cards2));
        Deque<String> g = new ArrayDeque<>(Arrays.asList(goal));
        
        while(!g.isEmpty()) {
            String a = g.poll();
            if (!c1.isEmpty() && c1.peek().equals(a)) {
                c1.poll();
            } else if (!c2.isEmpty() && c2.peek().equals(a)) {
                c2.poll();
            } else {
                return "No";
            }
        }
    
        return "Yes";
    }
}