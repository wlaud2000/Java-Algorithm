import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0];
        int healPerSec = bandage[1];
        int plusHeal = bandage[2];
        
        int maxHealth = health;
        int cnt = 0;
        int attackIdx = 0;
        int lastTime = attacks[attacks.length-1][0];
        
        for(int time=1; time<=lastTime; time++) {
            // 이번 초에 공격이 있는 경우
            if(time == attacks[attackIdx][0]) {
                health -= attacks[attackIdx][1];
                if(health<=0) {
                    return -1;
                }
                cnt=0;
                attackIdx++;
                continue;
            }
            // 이번 초에 공격이 없는 경우
            cnt++;
            health += healPerSec;
            if(cnt == t) {
                health+=plusHeal;
                cnt=0;
            }
            health = Math.min(health, maxHealth);
        }
        return health;
    }
}