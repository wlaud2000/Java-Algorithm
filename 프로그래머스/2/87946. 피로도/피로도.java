// 현재 피로도 = k
// 최소 필요 피로도 = 해당 던전을 탐험하기 위해 가지고 있어야 하는 최소한의 피로도 = dungeons[][0]
//     현재 피로도 >= 최소 필요 피로도 면
//         탐험 가능
//         현재 피로도 - 소모 피로도
//     아니면
//         탐험 불가
        
// 소모 피로도 = 턴던을 탐험한 후 소모되는 피로도 = dungeons[][1]

// 던전이 여러개 있는데 이 던전들을 최대한 많이 탐험

// 이거 백트래킹인가? dfs + 백트래킹
// visited 필요하나

// 일단 지금 몇번의 던전을 돌았는지 확인할 int sum 필요
// 그리고 해당 던전을 돌았는지 여부를 확인할 boolean[] visited 필요 -> boolean[] visited = new boolean[dungeons.length]

// public void dfs(int k, int[][] dungeons, int count, boolean[] visited)

import java.util.*;

class Solution {
    
    int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        
        dfs(k, dungeons, 0, visited);
        
        return answer;
    }
    
    public void dfs(int k, int[][] dungeons, int count, boolean[] visited) {
        answer = Math.max(count, answer);
        
        for(int i=0; i<dungeons.length; i++) {
            if(!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(k - dungeons[i][1], dungeons, count+1, visited);
                visited[i] = false;
            }
        }
    }
}