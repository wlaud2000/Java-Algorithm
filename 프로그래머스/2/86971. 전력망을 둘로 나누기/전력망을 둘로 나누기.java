import java.util.*;

class Solution {
    
    List<List<Integer>> graph = new ArrayList<>();
    
    public int solution(int n, int[][] wires) {
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 양방향 인접 리스트
        for(int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        
        int answer = n;
        
        for (int[] wire : wires) {
            boolean[] visited = new boolean[n+1];
            visited[wire[1]] = true; // 다른 트리로 가는 길 막기
            
            int count = dfs(wire[0], visited);
            answer = Math.min(answer, Math.abs(count - (n-count)));
        }
        
        return answer;
    }
    
    public int dfs(int cur, boolean[] visited) {
        visited[cur] = true;
        int count = 1; // 나 자신
        
        for (int next : graph.get(cur)) {
            if(!visited[next]) {
                count += dfs(next, visited);
            }
        }
        
        return count;
    }
}