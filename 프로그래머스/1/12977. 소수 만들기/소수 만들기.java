// 에라토스테네스의 체 활용

import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int n = nums.length;
        
        boolean[] isPrime = makeSieve(3000);
        
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
               for(int k=j+1; k<n; k++) {
                   int sum = nums[i] + nums[j] + nums[k];
                   
                   if(isPrime[sum]) {
                       answer++;
                   }
               } 
            }
        }
        return  answer;
    }
    
    boolean[] makeSieve(int max) {
        boolean[] isPrime = new boolean[max+1];
        Arrays.fill(isPrime, true);
        
        isPrime[0] = false;
        isPrime[1] = false;
        
        for(int i=2; i<=Math.sqrt(max); i++) {
            if(isPrime[i]) {
                for(int j=i*i; j<=max; j+=i) {
                    isPrime[j] = false;
                }
            }
        }
        return isPrime;
    }
}