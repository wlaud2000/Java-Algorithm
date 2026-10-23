// 2개 붙어있는거를 삭제하는걸 반복해서 남은게 없으면 1을 return 있으면 0을 return
    
// (스택에 하나씩 담아서 겹치는게 있으면 pop) 
//     -> 이걸 반복해서 스택이 비면 1을 return
//     -> 근데 계속 스택에 담기면 어캄 무한 반복으로
//         -> pop이 된게 count가 0이면 끝?

    
// 일단 s의 길이를 n으로 두고
// n만큼 반복해서 s.charAt(i)를 하나씩 List<Character> 에 담기

// dfs로 풀자
// int dfs(List<Character> list) {
//     int count = 0;

//     if(stack.isEmpty()) {
//         return 1;
//     }
    
//     int size = list.size();
//     Deque<Character> stack = ArrayDeque<Character>();
//     for(int i=0; i<size; i++) {
//         if(stack.isEmpty()) {
//             stack.push()
//         }
//         만약 스택이 비었으면 {
//             stack list.get(i) 를 push해줌
//         }
//         만약 스택이 안비었으면 {
//             stack.peek한거랑 list.get(i)랑 다르면 {
//                 stack에 list.get(i)를 push해줌
//             }
//             stack.peek한거랑 list.get(i)랑 같으면 {
//                 stack을 pop해줌
//                 count를 ++
//             }
//         }
//     }
    
//     if(count == 0) {
//         return 0;
//     }
    
//     List<Character> nextList = new ArrayList<>(stack);
    
//     dfs(nextList);
    
    
// }

import java.util.*;

class Solution
{
    Deque<Character> stack = new ArrayDeque<>();
    
    public int solution(String s)
    {
        int n = s.length();
        
        List<Character> list = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
            list.add(s.charAt(i));
        }
        
        return dfs(list);
    }
    
    public int dfs(List<Character> list) {
        int count = 0;
        
        int size = list.size();
        for(int i=0; i<size; i++) {
            if(stack.isEmpty()) {
                stack.push(list.get(i));
            }
            else if (!stack.isEmpty()) {
                if(stack.peek() != list.get(i)) {
                    stack.push(list.get(i));
                } else if (stack.peek() == list.get(i)) {
                    stack.pop();
                    count++;
                }
            }   
        }
        
        if(stack.isEmpty()) {
            return 1;
        }

        if(count == 0) {
            return 0;
        }

        List<Character> nextList = new ArrayList<>(stack);

        dfs(nextList);
        
        return 0;
    }
}