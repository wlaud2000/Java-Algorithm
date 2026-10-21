import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        
        HashMap<String, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for(int i=0; i<record.length; i++) {
            String[] items = record[i].split(" ");
            String item1 = items[0];
            
            if (item1.equals("Enter")) {
                String key = items[1];
                String value = items[2];
                
                map.put(key, value);
                
                list.add("Enter" + " " + key);
            }
            
            if (item1.equals("Leave")) {
                String key = items[1];
                list.add("Leave" + " " + key);
            }
            
            if(item1.equals("Change")) {
                String key = items[1];
                String value = items[2];
                
                map.put(key, value);
            }
        }
        
        for(int i=0; i<list.size(); i++) {
            String[] items = list.get(i).split(" ");
            String item = items[0];
            String key = items[1];
            
            if(item.equals("Enter")) {
                String value = map.get(key);
                answer.add(value + "님이 들어왔습니다.");
            }
            
            if(item.equals("Leave")) {
                String value = map.get(key);
                answer.add(value + "님이 나갔습니다.");
            }
        }
        
        
        
        return answer.stream().toArray(String[]::new);
    }
}