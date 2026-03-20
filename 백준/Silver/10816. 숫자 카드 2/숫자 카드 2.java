import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 해당 인덱스가 몇번 있었는지 카운트를 저장하는 배열
        // -10,000,000 <= M <= 10,000,000
        int counting[] = new int[20000001];

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            int now = Integer.parseInt(st.nextToken());
            counting[now + 10000000]++;
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            int now = Integer.parseInt(st.nextToken());
            bw.write(counting[now + 10000000] + " ");
        }

        bw.flush();
        
        // value를 index로 다루는 문제였다.
        // 바로 이렇게 생각나면 쉽게 풀 수 있는 문제다.
        // 재밌다. counting 배열의 개념을 잊지 말고 써먹어야겠다. -> 해당 인덱스가 몇번 카운트 되었는지
    }
}