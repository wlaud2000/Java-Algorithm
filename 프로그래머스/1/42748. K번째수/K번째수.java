import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        int[] answer = new int[commands.length];
        
        for(int cur=0; cur<commands.length; cur++) {
            int i = commands[cur][0];
            int j = commands[cur][1];
            int k = commands[cur][2];
            
            // 배열을 자르는 메서드 (start는 포함, end는 미포함하게 자름)
            int[] sliced = Arrays.copyOfRange(array, i-1, j);
            
            // 배열 정렬
            Arrays.sort(sliced);
            
            answer[cur] = sliced[k-1];
        }
        
        return answer;
    }
}