// [문제 요약]
// S에서 시작해서 L을 무조건 거쳐서 E로 나가라. 근데 X(벽)은 못가고 O만 갈 수 있다.
//     1칸당 1초 걸리는데 최소 시간을 return, 탈출 못하면 -1 return
//     그러면 S->L, L->E bfs를 두번 돌리고 두개를 더해주면 되겠다

// [변수]
// bfs 지역변수 : dist[][] -> 출발점에서의 거리가 저장되어 있는 2차원 배열(int) -> maps의 n,m
// bfs 지역변수 : Deque<int[]> q -> bfs 할 좌표가 들어있는 큐

// [풀이 과정]
// solution 함수
//     1. S와 L과 E의 좌표를 알아내기
//     2. S->L가는 bfs 실행
//     3. L->E가는 bfs 실행
//     4. 두개 더해서 return
// bfs 함수 bfs(maps, startX, startY, targetX, targetY)
//     0. startX랑 startY가 targetX, targetY면 지금 좌표의 dist값 return
//     1. 상하좌우 탐색해서 갈 수 있는 곳 Queue에 넣기
//     2. while(!q.isEmpty())
//         2-1. 현재 노드 기준으로 상, 하, 좌, 우 다 돌면서
//             2-1-1. 벽이면 continue
//             2-1-2. map 넘어가면 continue
//             2-1-3. 이미 간 곳이면 continue
//             2-1-4. 다 아니면 해당 좌표를 Queue에 넣고 그 다음 좌표의 dist값을 현재 dist 값 + 1해줌
//     3. while 끝났는데 target 좌표에 못갔으면 -1 return
        
import java.util.*;    

class Solution {
    public int solution(String[] maps) {
        // 1. S와 L과 E의 좌표를 알아내기
        int n = maps.length;
        int m = maps[0].length();
        
        char[][] maps2 = new char[n][m];
        
        int sx=0; int sy=0;
        int lx=0; int ly=0;
        int ex=0; int ey=0;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                char cur = maps[i].charAt(j);
                maps2[i][j] = cur;
                if(cur == 'S') { sx=i; sy=j; }
                if(cur == 'L') { lx=i; ly=j; }
                if(cur == 'E') { ex=i; ey=j; }
            }
        }
        
        // 2. S->L가는 bfs 실행
        int toLever = bfs(maps2, sx, sy, lx, ly);
        if(toLever == -1) return -1;
        
        // 3. L->E가는 bfs 실행
        int toExit = bfs(maps2, lx, ly, ex, ey);
        if(toExit == -1) return -1;
        
        //     4. 두개 더해서 return
        return toLever + toExit;
    }
    
    public int bfs(char[][] maps, int startX, int startY, int targetX, int targetY) {
        int n=maps.length;
        int m = maps[0].length;
        
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};
        
        int[][] dist = new int[n][m];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                dist[i][j] = -1;
            }
        }
        
        Deque<int[]> q = new ArrayDeque<>();
        
        q.add(new int[]{startX, startY});
        dist[startX][startY] = 0;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            int x = cur[0];
            int y = cur[1];
            
            if(x == targetX && y == targetY) {
                return dist[x][y];
            }
            
            for(int d=0; d<4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                if (nx < 0 || ny < 0 || nx >=n || ny >=m) continue;
                if (maps[nx][ny] == 'X') continue;
                if (dist[nx][ny] != -1) continue;
                
                dist[nx][ny] = dist[x][y] + 1;
                
                q.add(new int[]{nx, ny});
            }
        }
        
        return -1;
        
    }
}