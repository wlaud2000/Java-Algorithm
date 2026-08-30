// 한글자씩 읽고 숫자면 answer에 담음
// 다음 글자가 z면 0을 answer에 담고 i를 +3 해줌
// 다음 글자가 o면 1을 answer에 담고 i를 +2 해줌
// 다음 글자가 t면 그 다음 글자를 읽고 그 다음 글자가 w면 answer에 2를 담고 i를 +2, h면 answer에 3을 담고 i를 +4
// 다음 글자가 f면 그 다음 글자를 읽고 그 다음 글자가 o면 answer에 4를 담고 i를 +3, i면 answer에 5을 담고 i를 +3
// 다음 글자가 s면 그 다음 글자를 읽고 그 다음 글자가 i면 answer에 6를 담고 i를 +4, e면 answer에 7을 담고 i를 +4
// 다음 글자가 e면 8을 answer에 담고 i를 +4 해줌
// 다음 글자가 n면 9을 answer에 담고 i를 +3 해줌

import java.util.*;

class Solution {
    public int solution(String s) {
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++) {
            char cur = s.charAt(i);
            if (Character.isDigit(cur)) {
                sb.append(cur);
            } else if(cur == 'z') {
                sb.append(0);
                i+=3;
                continue;
            } else if(cur == 'o') {
                sb.append(1);
                i+=2;
                continue;
            } else if(cur == 'e') {
                sb.append(8);
                i+=4;
                continue;
            } else if(cur == 'n') {
                sb.append(9);
                i+=3;
                continue;
            } else if(cur == 't') {
                char next = s.charAt(i+1);
                if(next == 'w') {
                    sb.append(2);
                    i+=2;
                    continue;
                } else if (next == 'h') {
                    sb.append(3);
                    i+=4;
                    continue;
                }
            } else if(cur == 'f') {
                char next = s.charAt(i+1);
                if(next == 'o') {
                    sb.append(4);
                    i+=3;
                    continue;
                } else if (next == 'i') {
                    sb.append(5);
                    i+=3;
                    continue;
                }
            } else if(cur == 's') {
                char next = s.charAt(i+1);
                if(next == 'i') {
                    sb.append(6);
                    i+=2;
                    continue;
                } else if (next == 'e') {
                    sb.append(7);
                    i+=4;
                    continue;
                }
            }
        }
        
        String str = sb.toString();
        return Integer.parseInt(str);
    }
}