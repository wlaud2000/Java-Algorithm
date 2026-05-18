import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (int i=0; i<arr.length; i++) {
            if (i == 0 || arr[i] != arr[i-1]) {
                answer.add(arr[i]);
            }
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}