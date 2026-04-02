import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // dp를 쓸거임.
        // 1. 테이블 정의
        // dp[i] -> i를 1로 만들 때 연산을 해야하는 횟수의 최솟값
        int dp[] = new int[N+1];

        // 2. 초기값 설정
        dp[0] = dp[1] = 0;

        // 3. 점화식 찾기
        // if 3으로 나누기 -> dp[i] = dp[i/3] + 1 | if 2로 나누기 -> dp[i] = dp[i/2] + 1 | if 1 빼기 -> dp[i] = dp[i-1] + 1
        // 이거 3개중에 최솟값 저장해주기
        for (int i=2; i<=N; i++) {
            dp[i] = dp[i-1] + 1;
            if (i % 2 ==0) {
                dp[i] = Math.min(dp[i], (dp[i/2] + 1));
            }
            if (i % 3 ==0) {
                dp[i] = Math.min(dp[i], (dp[i/3] + 1));
            }
        }

        // 4. 출력
        System.out.println(dp[N]);
    }
}
