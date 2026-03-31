import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        // BR로 N 가져오기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        // 1~5까지는 규칙이 없으니까 해시맵 만들어서 수동으로 넣어주기
        // P(100) 이면 int 오버플로우 나니까 Long으로 변경
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(1,1L);
        hashMap.put(2,1L);
        hashMap.put(3,1L);
        hashMap.put(4,2L);
        hashMap.put(5,2L);

        // key가 6부터 규칙이 있으니까 for문으로 key-value put
        for (int i=6; i<=100; i++) {
            hashMap.put(i, (hashMap.get(i-1) + hashMap.get(i-5)));
        }

        // N만큼 반복해서 hashMap에서 value을 get
        for (int i=0; i<N; i++) {
            int key = Integer.parseInt(br.readLine());
            long result = hashMap.get(key);
            bw.write(String.valueOf(result));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
