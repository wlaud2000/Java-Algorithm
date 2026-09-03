// phone book을 반복
// 안에 값들을 한 문자씩 substring하면서 점점 늘려가면서 그게 HashSet에 있는지 확인하기
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<>(Arrays.asList(phone_book));
        
        for(String key : phone_book) {
            String prefix = "";
            for(int i=1; i<key.length(); i++) {
                prefix = key.substring(0,i);
                
                if(set.contains(prefix)) {
                    return false;
                }
            }
        }
        return true;
    }
}