import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long n = Long.parseLong(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] sizes = new long[6];
        for (int i = 0; i < 6; i++) {
            sizes[i] = Long.parseLong(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        long t = Long.parseLong(st.nextToken());
        long p = Long.parseLong(st.nextToken());
        
        // 티셔츠: 각 사이즈별 올림 나눗셈 합
        long shirtBundles = 0;
        for (int i = 0; i < 6; i++) {
            shirtBundles += sizes[i] / t;
            if (sizes[i] % t != 0) shirtBundles++;
        }
        
        // 펜: 몫과 나머지
        long penBundles = n / p;
        long penSingles = n % p;
        
        System.out.println(shirtBundles);
        System.out.println(penBundles + " " + penSingles);
    }
}