// numbers target

// target되는 모든 경우의 수 -> DFS 탐색

// dfs 메서드를 따로 만들어주자!

// +, - 두가지 분기

// dfs를 파고들면서 넘겨줄것들
//     numbers, target, sum, depth
// dfs에서 종료조건
//     if(depth==numbers.length) {
//         if (sum == target) {
//             answer++;
//         }
//     }


import java.util.*;

class Solution {
    
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int sum, int depth) {
        if(depth == numbers.length) {
            if(sum==target) {
                answer++;
            }
            return;
        }
        
        // +, - 두가지 분기
        dfs(numbers, target, sum + numbers[depth], depth+1);
        dfs(numbers, target, sum - numbers[depth], depth+1);
    }
}