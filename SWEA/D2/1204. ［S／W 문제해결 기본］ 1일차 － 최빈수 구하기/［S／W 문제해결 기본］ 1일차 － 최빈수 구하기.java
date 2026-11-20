import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            int many = 0;
            int answer = 0;

            HashMap<Integer, Integer> map = new HashMap<>();
            br.readLine();
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<1000; i++) {
                int key = Integer.parseInt(st.nextToken());
                map.put(key, map.getOrDefault(key, 0)+1);
            }

            for(int key : map.keySet()) {
                int cnt = map.get(key);

                if(cnt > many) {
                    many = cnt;
                    answer = key;
                } else if(cnt == many && key > answer) {
                    answer = key;
                }
            }
            sb.append("#").append(tc).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
    }
}