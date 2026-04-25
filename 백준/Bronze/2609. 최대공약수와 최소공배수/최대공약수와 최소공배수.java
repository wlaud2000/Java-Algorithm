import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int sol1 = gcd(a, b);
        int sol2 = (a*b)/sol1;
        System.out.println(sol1);
        System.out.println(sol2); // 최소 공배수는 두 값을 곱해서 최대 공약수로 나눠주면 된다.
    }

    // 최대 공약수를 구하는 유클리드 호제법 반복문으로 사용 이거 잘 알아두기!!!!!!!
    public static int gcd(int a, int b) {
        while(b!=0) {
            int r = a % b;

            a = b;
            b = r;
        }
        return a;
    }
}
