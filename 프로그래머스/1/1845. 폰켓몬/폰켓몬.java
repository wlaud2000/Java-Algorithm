import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int max = nums.length/2;
        
        for (Integer n: nums) {
            map.put(n, map.getOrDefault(n,0)+1);
        }
        
        int ans = map.size();
        
        if (ans > max) {
            return max;
        } else {
            return ans;
        }
    }
}