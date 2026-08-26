import java.util.*;

class Solution {
    public int[] solution(int n) {
        int tri[][] = new int[n][n];
        
        int x=-1, y=0;
        int num = 0;
        int dir = 0;
        
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                switch(dir) {
                    case 0: x++; break;
                    case 1: y++; break;
                    case 2: x--; y--; break;
                }
                tri[x][y] = ++num; // 값을 1 올리고 대입
            }
            dir = (dir + 1) % 3;
        }
        
        List<Integer> answer = new ArrayList<>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<=i; j++) {
                answer.add(tri[i][j]);
            }
        }
        
        int[] result = new int[answer.size()];
        for(int k=0; k<result.length; k++) {
            result[k] = answer.get(k);
        }
        return result;
    }
}