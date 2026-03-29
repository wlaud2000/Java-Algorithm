import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 해시맵으로 하면 될듯? 그리고 containskey로 있는지 확인하고 value get해서 출력
        // ---
        // 우선 BR이랑 BW랑 ST 만들어서 N, M값 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // HashMap<String,String> 선언해서 N개의 값 저장
        HashMap<String, String> hashMap = new HashMap<>();
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            hashMap.put(st.nextToken(), st.nextToken());
        }

        // br.readLine()해서 containskey로 key가 있는지 확인 후 있으면 bw에 담았다가 flush해서 출력
        for (int i=0; i<M; i++) {
            String target = br.readLine();
            if (hashMap.containsKey(target)) {
                bw.write(hashMap.get(target));
                bw.write("\n");
            }
        }
        bw.flush();

        br.close();
        bw.close();
    }
}
