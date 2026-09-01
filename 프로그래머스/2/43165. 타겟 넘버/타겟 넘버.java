import java.util.*;

class Solution {
    
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
    
    // 무엇이 한 단계씩 진행되는가? → 첫 번째 매개변수 -> 배열의 인덱스(depth)
    // 답을 내려면 뭘 들고 다녀야 하는가? → 나머지 매개변수 -> sum
    // 더 갈 곳이 없는 건 언제인가? → 종료 조건 -> 배열에 남은 숫자가 없을 때
    // 되돌아올 수 있는 구조인가? → visited 여부 -> 없음
    void dfs(int[] numbers, int target, int depth, int sum) {
        // 종료 조건
        if(depth == numbers.length) {
            if(sum == target) {
                answer++;
            }
            return;
        }
        
        // 다음 단계
        dfs(numbers, target, depth+1, sum+numbers[depth]); // 더하기
        dfs(numbers, target, depth+1, sum-numbers[depth]); // 빼기
    }
}