import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=10; i++) {
            int answer = 0;
            int t = Integer.parseInt(br.readLine());
            String a = br.readLine();
            int[] building = makeBuilding(t, a);
            for(int j=2; j<t-2; j++) {
                int cur = Integer.MAX_VALUE;
                if(building[j] - building[j-2] < 0) {
                    continue;
                } else {
                    cur = Math.min(cur, building[j] - building[j-2]);
                }

                if(building[j] - building[j-1] < 0) {
                    continue;
                } else {
                    cur = Math.min(cur, building[j] - building[j-1]);
                }

                if(building[j] - building[j+1] < 0) {
                    continue;
                } else {
                    cur = Math.min(cur, building[j] - building[j+1]);
                }

                if(building[j] - building[j+2] < 0) {
                    continue;
                } else {
                    cur = Math.min(cur, building[j] - building[j+2]);
                }
                answer += cur;
            }

            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }

    public static int[] makeBuilding(int t, String a) {
        StringTokenizer st = new StringTokenizer(a);
        int[] building = new int[t];
        for(int i=0; i<t; i++) {
            building[i] = Integer.parseInt(st.nextToken());
        }
        return building;
    }
}
