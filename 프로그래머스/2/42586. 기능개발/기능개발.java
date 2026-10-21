// progresses

// speeds

// 100 이상이면 된다

// length만큼 반복해서 각각이 언제 100 이상이 되는지를 알기
// 스택에 넣는데, 앞에 들어간 숫자가 지금 들어가는 수보다 더 크면 같은 날 배포됨

// 7 3 9
//     7 시작
//     7 > 3 -> 7이 더 큼 -> 같이 감
    
//     7 < 9 -> 9가 더 큼 -> 따로 감
// 5 10 1 1 20 1
//     5 시작
    
//     5 < 10 -> 10이 더 큼 -> 따로 감
//     10 > 1 -> 10이 더 큼 -> 같이 감
//     10 > 1 -> 10이 더 큼 -> 같이 감
    
//     10 < 20 -> 20이 더 큼 -> 따로 감
//     20 > 1 -> 2-이 더 큼 -> 같이 감

// 그니까 따로가기 전까지는, 그니까 가장 큰게 갱신되기 전까지는 그 전에 가장 큰거랑 비교
// 앞에 수가 더 크면 같이가기 -> +1
// 뒤에 수가 더 크면 따로가기 -> 다음 배열로 넘어가기

// progresses length만큼 반복
//     100프로까지 남은 수 = 100 - progresses[i]
//     list에 저장 (list 필요 1)[이름 : list]

// speeds length만큼 반복
//     100프로까지 남은 day= (int)(Math.ceil((double)list.get(i) / speeds[i]))
//     list에 저장(list 필요 2)[이름 : dayList]

// int item = 0; 변수 필요
// int moreBig = 0; 바뀌기 전까지 가장 큰 수 저장하는 변수

// dayList만큼 반복
//     스택필요(stack)
    
//     int cur = dayList.get(i);
    
//     stack이 비어있으면 
//         push(cur)
//         item++;
//         moreBig = cur;
    
//     만약 moreBig보다 지금 넣는 수가 작거나 같으면
//         item++;
    
//     만약 moreBig보다 지금 넣는 수가 크면
//         result에 item을 추가해주고
//         moreBig = cur;
//         item = 1;

// 그리고 result 반환

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        List<Integer> dayList = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        
        List<Integer> result = new ArrayList<>();
        
        for(int i=0; i<progresses.length; i++) {
            int a = 100-progresses[i];
            list.add(a);
        }

        for(int i=0; i<speeds.length; i++) {
            int leftDay = (int)(Math.ceil((double)list.get(i) / speeds[i]));
            dayList.add(leftDay);
        }
        
        int item = 0;
        int moreBig = 0; // 바뀌기 전까지 가장 큰 수 저장하는 변수

        int size = dayList.size();
        
        if (stack.isEmpty()) {
                stack.push(dayList.get(0));
                item++;
                moreBig = dayList.get(0);
        }
        
        for(int i=1; i<size; i++) {
            
            int cur = dayList.get(i);
            
            if (moreBig >= cur) {
                item++;
            }
            
             else if (moreBig < cur) {
                 result.add(item);
                 moreBig = cur;
                 item = 1;
             }
            
            if(i==size-1) {
                result.add(item);
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}