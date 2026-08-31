// 문제 설명
    // 정수 배열 numbers
    // numbers에서 서로 다른 인덱스에 있는 두개의 수를 뽑아 더해서 만들 수 있는 모든 수를 배열에 오름차순으로 담아 return
// 제한 사항
    // numbers의 길이는 2 이상 100 이하
    // numbers의 모든 수는 0이상 100이하
// 브레인 스토밍
    // numbers 배열 오름차순 정렬
    // for문 2개
        // 첫번째 for문에서는 원소를 뽑음(cur)
        // 두번째 for문에서는 다음 원소를 뽑아서 cur이랑 더해서 result에 넣음.
            // 만약 result에 이미 있다면 continue
    // for문이 끝나면 result를 정렬 후 return


import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        
        List<Integer> result = new ArrayList<>();
        
        // numbers 배열 오름차순 정렬
        Arrays.sort(numbers);
        
        // 첫번째 for문에서는 원소를 뽑음(cur) i=0, i<numbers.length-1, i++
        // 전에거랑 연산 할 필요는 없음 이미 했으니까
        for(int i=0; i<numbers.length-1; i++) {
            int cur = numbers[i];
            // 두번째 for문에서는 다음 원소를 뽑아서 cur이랑 더해서 result에 넣음.
            // j=i+1, j<numbers.length; j++
            for(int j=i+1; j<numbers.length; j++) {
                int plus = numbers[j];
                int item = cur + plus;
                // 만약 result에 이미 있다면 continue
                if(result.contains(item)) {
                    continue;
                } else {
                    result.add(item);
                }
            }
        }
        
        // for문이 끝나면 result를 정렬 후 return
        return result.stream().mapToInt(Integer::intValue).sorted().toArray();
    }
}