// 10만원 이상은 5% 할인, 30만원 이상은 10% 할인, 50만원 이상 사면 20% 할인.
// price가 매개변수

import java.util.*;

class Solution {
    public int solution(int price) {
        if(10 <= price && price < 100000) {
            return price;
        }
        
        else if(100000 <= price && price < 300000 ) {
            return (int)(price*0.95);
        }
        
        else if(300000 <= price && price < 500000 ) {
            return (int)(price*0.9);
        }
        
        else if(500000 <= price && price <= 1000000 ) {
            return (int)(price*0.8);
        }
        
        return 0;
    }
}