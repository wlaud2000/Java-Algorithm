import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 이거 그 뭐시기 무슨 에라토스? 체 사용하는 문제네 소수 구하는거니까
    public static void main(String[] args) throws IOException {
        // BR이랑 ST로 받아줌 M 이랑 N
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        // 그리고 배열에 인덱스 값을 저장해야 함. 일단 0번째는 버릴거니까 N+1 해서 채워줌
        int[] A = new int[N+1];
        for (int i=1; i<=N; i++) {
            A[i] = i;
        }

        // 1은 소수가 아니니까
        A[1] = 0;
        
        // 그리고 소수는 2부터 시작이니까 2부터 종료수의 제곱근만큼 반복
        for (int i=2; i<=Math.sqrt(N); i++) {
            // 우리는 소수가 아닌걸 0으로 채워줄거임
            if (A[i]==0) {
                continue;
            }
            // 만약 소수라면 해당 수를 제외하고 해당 수의 배수를 0으로 바꿔줌.
            for (int j=i+i; j<=N; j=j+i) {
                A[j] = 0;
            }
        }

        // 이건 출력임. M~N 까지 반복
        for (int i=M; i<=N; i++) {
            // 0이면 소수가 아니라는거니까 continue
            if (A[i]==0) {
                continue;
            }
            // 0이 아니면 소수니까 A[i]를 출력
            System.out.println(A[i]);
        }
    }
}
