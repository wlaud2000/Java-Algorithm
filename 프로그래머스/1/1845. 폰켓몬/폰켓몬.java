// 홍박사님 포켓몬 N/2마리 가져가기
// 가질 수 있는 최댓값 조합 찾기
// 해시맵? 해시셋? 해시맵으로가자 Integer , Integer
// nums를 돌면서 key(포켓몬 번호) 나오면 value를 +1해주기?
// 일단 nums의 lenght/2가 최대임 int limit = nums.length / 2
// 그래서 맵의 key의 개수 > limit 이면 limit리턴, key의 개수 < limit이면 key의 개수 리턴
// 그럼 set으로 해도 되는거 아닌가? set으로 하자

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        // 해시셋 선언
        HashSet<Integer> set = new HashSet<>();
        
        // nums 돌면서 해시셋 채워주기 
        for(int key : nums) {
            set.add(key);
        }
        
        // limit 선언
        int limit = nums.length/2;
        
        // key의 개수 > limit 이면 limit리턴, key의 개수 < limit이면 key의 개수 리턴
        if(set.size() > limit) {
            return limit;
        } else {
            return set.size();
        }
    }
}