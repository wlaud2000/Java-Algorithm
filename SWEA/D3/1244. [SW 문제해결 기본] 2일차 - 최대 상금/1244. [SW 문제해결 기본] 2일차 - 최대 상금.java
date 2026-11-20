import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

    static char[] num;
    static int swapCnt;
    static int best;
    static HashSet<Integer>[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int tc=1; tc<=T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            num = st.nextToken().toCharArray();
            swapCnt = Integer.parseInt(st.nextToken());

            best = 0;
            visited = new HashSet[swapCnt + 1];
            for (int k = 0; k <= swapCnt; k++) visited[k] = new HashSet<>();

            dfs(0);
            sb.append('#').append(tc).append(' ').append(best).append('\n');
        }
        System.out.print(sb);
    }

    public static void dfs(int depth) {
        if(depth == swapCnt) {
            best = Math.max(best, Integer.parseInt(new String(num)));
            return;
        }
        
        for(int i=0; i<num.length; i++) {
            for(int j=i+1; j<num.length; j++) {
                swap(i,j);
                int cur = Integer.parseInt(new String(num));
                if(!visited[depth+1].contains(cur)) {
                    visited[depth+1].add(cur);
                    dfs(depth+1);
                }
                swap(i,j);
            }
        }
    }
    
    public static void swap(int i, int j) {
        char tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
}
