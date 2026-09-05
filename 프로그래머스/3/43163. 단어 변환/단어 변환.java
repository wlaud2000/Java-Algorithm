import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        Queue<String> q = new ArrayDeque<>();
        q.offer(begin);
        
        int step = 0;
        
        while(!q.isEmpty()) {
            int size = q.size(); // 현재 레벨에 있는 노드 개수
            step++; // 한 레벨 내려감 = 변환 1회
            
            for(int i=0; i<size; i++) {
                String cur = q.poll(); // 이번 턴의 기준점
                
                for (int j=0; j<words.length; j++) {
                    if(visited[j]) {
                        continue;
                    }
                    if(!canConvert(cur, words[j])) {
                        continue;
                    }
                    
                    if(words[j].equals(target)) {
                        return step;
                    }
                    
                    visited[j] = true; // 큐에 넣는 순간 방문 처리
                    q.offer(words[j]);
                }
            }
        }
        
        return 0;
    }
    
    // 간선 존재 여부: 정확히 한 글자만 다른가?
    private boolean canConvert(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
            if (diff > 1) return false;
        }
        return diff == 1;
    }
}