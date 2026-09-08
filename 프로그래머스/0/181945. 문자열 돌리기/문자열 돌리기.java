import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<a.length(); i++) {
            char cur = a.charAt(i);
            sb.append(cur);
            sb.append("\n");
        }
        
        System.out.println(sb.toString());
    }
}