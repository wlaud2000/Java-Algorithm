import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int basicMinute = fees[0];
        int basicFee = fees[1];
        int minute = fees[2];
        int minuteFee = fees[3];
        
        HashMap<String, String> map = new HashMap<>();
        HashMap<String, Integer> minuteMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        
        for(int i=0; i<records.length; i++) {
            String[] items = records[i].split(" ");
            
            String key = items[1];
            String value = items[0];
            String item = items[2];
            
            if(item.equals("IN")) {
                map.put(key, value);
            }
            
            if(item.equals("OUT")) {
                String oldValue = map.get(key);
                int minute2 = minuteCal(oldValue, value);
                map.remove(key);
                
                if(minuteMap.containsKey(key)) {
                    minuteMap.put(key, minuteMap.get(key)+minute2);
                } else {
                    minuteMap.put(key, minute2);
                }
            }
        }
        
        if(!map.isEmpty()) {
            for (String key : map.keySet()) {
                String value = map.get(key);
                int minute3 = minuteCal(value, "23:59");
                
                if(minuteMap.containsKey(key)) {
                    minuteMap.put(key, minuteMap.get(key)+minute3);
                } else {
                    minuteMap.put(key, minute3);
                }
            }
        }
        
        List<String> sortedKeys = new ArrayList<>(minuteMap.keySet());
        Collections.sort(sortedKeys);
        
        for(String key : sortedKeys) {
            if(minuteMap.get(key) <= basicMinute) {
                result.add(basicFee);
            } else {
                int ceil = (int)(Math.ceil(((double)(minuteMap.get(key) - basicMinute)/minute))) * minuteFee;
                result.add(basicFee + ceil);
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public int minuteCal(String oldValue, String value) {
        String[] old = oldValue.split(":");
        String[] cur = value.split(":");
        int oldMin = (60 * Integer.parseInt(old[0])) + Integer.parseInt(old[1]);
        int curMin = (60 * Integer.parseInt(cur[0])) + Integer.parseInt(cur[1]);
        
        return curMin-oldMin;
    }
}