// 같은 계산이 여러번 나옴, 작은 부분의 답으로 큰 부분의 답이 만들어짐 = DP
import java.util.*;

class Solution {
    public int solution(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        
        for(int i=2; i<n+1; i++) {
            dp[i] = (dp[i-2] + dp[i-1])%1234567;
        }
        
        return dp[n];
    }
}