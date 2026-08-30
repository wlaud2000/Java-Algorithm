// 부서별 신청한 금액 배열 d, 예산 budget 매개변수
// 최대한 많은 부서의 물품 구매할 수 있는지 return
// d의 길이는 1이상 100이하, d의 원소의 크기는 1이상 100,000이하
// budget은 1이상 10,000,000 이하

// 1, 3,2,3,2,5,2     14 -> 정렬 1,2,2,2,3,3,5 1+2+2+2+3+3 = 13 -> 6개
// 우선 주어진 배열을 정렬, 그리고 앞에있는 원소부터 차례대로 더하면서 budget이 넘으면 끝


import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        
        int answer = 0;
        
        Arrays.sort(d);
        
        int a = 0;
        
        for(int e : d) {
            a = a+e;
            if(a<budget) {
                answer++;
            } else if(a>budget) {
                break;
            } else if(a == budget) {
                answer++;
                break;
            }
        }
        
        return answer;
    }
}