// dp[i][j] = i행 j열에서 끝났을 때 최고 점수

// 점화식 = dp[i][j] = land[i][j] + max(dp[i-1][k]) , k는 j면 안됨

// 초기값 = dp[0][j] = land[0][j]

// 답 위치 -> 마지막 행 4칸 중 최댓값

import java.util.*;

class Solution {
    int solution(int[][] land) {
        
        int n = land.length;
        int m = land[0].length;
        
        int[][] dp = new int[n][m];
        
        dp[0][0] = land[0][0];
        dp[0][1] = land[0][1];
        dp[0][2] = land[0][2];
        dp[0][3] = land[0][3];
        
        for(int i=1; i<n; i++) {
            for(int j=0; j<m; j++) {
                int prevMax = 0;
                for(int k=0; k<m; k++) {
                    if(j == k) continue;
                    prevMax = Math.max(prevMax, dp[i-1][k]);
                }
                dp[i][j] = prevMax + land[i][j];
            }
        }
        
        int answer = 0;
        for(int j=0; j<m; j++) {
            answer = Math.max(answer, dp[n-1][j]);
        }
        
        return answer;
    }
}