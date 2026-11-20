import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i=1; i<=n; i++) {
            boolean yes = false;
            int yesNum = 0;
            String cur = String.valueOf(i);
            int length = cur.length();
            for(int j=0; j<length; j++) {
                char curChar = cur.charAt(j);
                if(curChar == '3' || curChar == '6' || curChar == '9') {
                    yes = true;
                    yesNum++;
                }
            }

            if(yes) {
                for(int y=0; y<yesNum; y++) sb.append("-");
            } else {
                sb.append(cur);
            }
            sb.append(" ");
        }

        System.out.print(sb);
    }
}