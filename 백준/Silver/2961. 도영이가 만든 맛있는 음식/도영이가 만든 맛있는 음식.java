import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        int[] sourAry = new int[n];
        int[] bitterAry = new int[n];
        
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            sourAry[i] = Integer.parseInt(st.nextToken());
            bitterAry[i] = Integer.parseInt(st.nextToken());            
        }
        
        int answer = Integer.MAX_VALUE;
        
        // 모든 경우의수 탐색
        int total = (int)Math.pow(2,n);
        
        for(int mask=1; mask<total; mask++) {
            int sour = 1;
            int bitter = 0;
            
            for(int i=0; i<n; i++) {
                if(((mask >> i) & 1) == 1) {
                    sour = sour * sourAry[i];
                    bitter = bitter + bitterAry[i];
                }
            }
            answer = Math.min(answer, Math.abs(sour - bitter));
        }
        System.out.println(answer);
    }
}