import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> ary = new ArrayList<>();
        ary.add(0);
        ary.add(1);
        ary.add(2);

        for (int i=3; i<=1000; i++) {
            // (a + b) % m == ((a % m) + (b % m)) % m -> 모듈러 연산의 성질
            // 매 단계에서 나머지 구하기... 왜냐면 int 오버플로우 남...
            ary.add(((ary.get(i-2) + ary.get(i-1))) % 10007);
        }

        int sol = ary.get(N);
        int result = sol % 10007;
        System.out.println(result);
    }
}
