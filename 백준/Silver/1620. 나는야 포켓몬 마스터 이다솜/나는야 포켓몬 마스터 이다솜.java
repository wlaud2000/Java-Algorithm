import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // br, st로 N,M값 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // <Bulbasaur, 1> , <1, Bulbasaur> 이런식으로 저장하고 비교해서 출력할거여셔 String, String으로 선언
        HashMap<String, String> hashMap = new HashMap<>();

        // N만큼 반복
        for (int i=1; i<=N; i++) {
            String name = br.readLine();
            hashMap.put(name, String.valueOf(i));
            hashMap.put(String.valueOf(i), name);
        }

        // M만큼 반복
        for (int i=0; i<M; i++) {
            String key = br.readLine();
            if (hashMap.containsKey(key)) {
                String value = hashMap.get(key);
                bw.write(value);
                bw.newLine();
            }
        }
        bw.flush();

        br.close();
        bw.close();
    }
}
