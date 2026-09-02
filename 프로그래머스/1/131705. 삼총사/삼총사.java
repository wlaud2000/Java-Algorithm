// 문제설명
    // 3명의 정수 번호를 더했을 때 0이 되면 삼총사
    // 주어진 number 배열에서 3개를 더해서 0이 되는 조합의 수를 구하라
// 제한사항
    // number의 길이가 3이상 13이하니까 완전탐색 해도 될듯함, dfs로 풀어도 될듯??
// 브레인스토밍
    // dfs 끝나는 조건 : 원소가 3개가 됐을 때
    // 넘어가는 변수 : sum 
    // 파라미터 : number, cur, depth

import java.util.*;

class Solution {
    
    int answer = 0;
    
    public int solution(int[] number) {
        dfs(0, number, 0, 0);

        return answer;
    }
    
    void dfs(int cur, int[] number, int depth, int sum) {
        if(depth == 3) {
            if(sum == 0) {
                answer++;
            }
        }
        for(int next = cur; next<number.length; next++) {
            dfs(next+1, number, depth+1, sum+number[next]);
        }
    }
}