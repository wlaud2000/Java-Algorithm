import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        return bfs(maps);
    }
    
    int bfs (int[][] maps) {
        int n = maps.length; // 세로 칸 수 (row 개수)
        int m = maps[0].length; // 가로 칸 수 (col 개수)
        
        // 방문 체크 배열
        boolean[][] visited = new boolean[n][m];
        
        // 4방향 이동을 배열 하나로 관리
        // dr[i], dc[i] 가 한 쌍으로 "i번째 방향으로 이동"을 의미
        // 아래(row+1), 위(row-1), 오른쪽(col+1), 왼쪽(col-1)
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        
        // BFS의 핵심 자료구조 : Queue
        Queue<int[]> queue = new ArrayDeque<>();
        
        // 시작점 (0,0)을 큐에 넣고 방문 처리
        int[] startPoint = {0, 0};
        queue.offer(startPoint);
        visited[0][0] = true;
        
        // 큐가 빌 때까지 반복. "빈다"는 건 더 이상 갈 수 있는 새로운 칸이 없다는 뜻.
        while(!queue.isEmpty()) {
            // 큐에서 하나 꺼냄. 이게 "지금까지 발견한 것 중 가장 먼저 들어온(=가장 가까운) 칸"
            int[] cur = queue.poll();
            int row = cur[0];
            int col = cur[1];
            
            // 이 칸을 기준으로 4방향을 전부 시도
            // 스택 문제들처럼 "if로 하나만 골라 타는 것"이 아니라
            // 여기서 4방향 다 큐에 넣어야 함
            for(int i=0; i<4; i++) {
                int nextRow = row + dr[i];
                int nextCol = col + dc[i];
                
                // 조건 1 : 배열 범위 안에 있는지 (음수거나 n, m을 넘으면 안됨)
                if (nextRow < 0 || nextRow >=n || nextCol < 0 || nextCol >= m) {
                    continue; // 범위 밖이면 이 방향은 포기
                }
                
                // 조건 2 : 그 칸이 벽(0)이 아니라 길(1)인지
                if (maps[nextRow][nextCol] == 0) {
                    continue;
                }
                
                // 조건 3 : 아직 안 가본 곳인지
                if (visited[nextRow][nextCol]) {
                    continue;
                }
                
                // 여기까지 통과했으면 "새로 밟을 수 있는 칸"이 확정된 것
                
                // 걸음 수 갱신 : 지금 칸의 걸음 수 + 1
                // maps 배열 자체를 "여기까지 오는 데 몇 칸 걸렸는지" 기록하는 용도로 재활용
                maps[nextRow][nextCol] = maps[row][col] + 1;
                
                // 방문 처리 (다시 큐에 안 들어가게)
                visited[nextRow][nextCol] = true;
                
                // 큐에 추가 -> 나중에 이 칸에서 또 4방향으로 퍼져나갈 차례를 기다림
                int[] nextStep = {nextRow, nextCol};
                queue.offer(nextStep);
            }
        }
        
        // 큐가 다 빌 때까지 돌았는데, 도착점(n-1, m-1)에 한번도 못 갔으면
        // maps[n-1][m-1]은 여전히 원래 값(1)일 것 -> 즉 "도달 못 함" 을 구분할 방법이 필요
        
        // 도착점이 방문됐는지로 판단하는게 안전함
        if(visited[n-1][m-1]) {
            return maps[n-1][m-1];
        } else {
            return -1;
        }
    }
}