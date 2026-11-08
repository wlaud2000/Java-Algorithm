import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        
        int n = park.length;
        int m = park[0].length();
        
        char[][] map = new char[n][m];
        int[] cur = new int[2];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                char item = park[i].charAt(j);
                if(item == 'S') {
                    cur[0] = i;
                    cur[1] = j;
                }
                map[i][j] = item;
            }
        }
        
        for(String key : routes) {
            String direction = key.substring(0,1);
            int num = Integer.parseInt(key.substring(2));
            
            if(direction.equals("W")) {
                int origin = cur[1];
                for(int i=0; i<num; i++) {
                    int ny = cur[1] - 1;
                    if(ny < 0 || ny >= m) {
                        cur[1] = origin;
                        break;
                    }
                    if(map[cur[0]][ny] == 'X') {
                        cur[1] = origin;
                        break;
                    }
                    cur[1] = ny;
                }
            } else if(direction.equals("E")) {
                int origin = cur[1];
                for(int i=0; i<num; i++) {
                    int ny = cur[1] + 1;
                    if(ny < 0 || ny >= m) {
                        cur[1] = origin;
                        break;
                    }
                    if(map[cur[0]][ny] == 'X') {
                        cur[1] = origin;
                        break;
                    }
                    cur[1] = ny;
                }
            } else if(direction.equals("S")) {
                int origin = cur[0];
                for(int i=0; i<num; i++) {
                    int nx = cur[0] + 1;
                    if(nx <0 || nx >= n) {
                        cur[0] = origin;
                        break;
                    }
                    if(map[nx][cur[1]] == 'X') {
                        cur[0] = origin;
                        break;
                    }
                    cur[0] = nx;
                }
            } else if(direction.equals("N")) {
                int origin = cur[0];
                for(int i=0; i<num; i++) {
                    int nx = cur[0] - 1;
                    if(nx <0 || nx >= n) {
                        cur[0] = origin;
                        break;
                    }
                    if(map[nx][cur[1]] == 'X') {
                        cur[0] = origin;
                        break;
                    }
                    cur[0] = nx;
                }
            }
        }
        return cur;
    }
}