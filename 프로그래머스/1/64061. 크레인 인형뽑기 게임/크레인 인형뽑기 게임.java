import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Deque<Integer> basket = new ArrayDeque<>();
        
        for (int move : moves) {
            for (int row = 0; row < board.length; row++) {
                int col = move - 1;
                
                if (board[row][col] == 0) {
                    continue;
                }
                
                int doll = board[row][col];
                board[row][col] = 0;
                
                if(!basket.isEmpty() && basket.peek().equals(doll)) {
                    basket.pop();
                    answer += 2;
                } else {
                    basket.push(doll);
                }
                break;
            }
        }
        
        return answer;
    }
}