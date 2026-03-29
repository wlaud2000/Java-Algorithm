import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 시간 제한 1.5초니까 해시 사용하고 Buffered 듀오 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        
        // 뭐 해시의 value를 사용하는게 아니라 있는지 없는지만 확인하기 때문에 HashSet으로 충분하다고 판단
        HashSet<Integer> hashSet = new HashSet<>();

        // N만큼 반복문
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String target = st.nextToken();

            // switch case 사용
            switch (target) {
                case "add":
                    hashSet.add(Integer.parseInt(st.nextToken()));
                    break;
                case "remove":
                    hashSet.remove(Integer.parseInt(st.nextToken()));
                    break;
                case "check":
                    int num1 = Integer.parseInt(st.nextToken());
                    if (hashSet.contains(num1)) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;
                case "toggle":
                    int num2 = Integer.parseInt(st.nextToken());
                    if (hashSet.contains(num2)) {
                        hashSet.remove(num2);
                    } else {
                        hashSet.add(num2);
                    }
                    break;
                case "all":
                    for (int j=1; j<=20; j++) {
                        hashSet.add(j);
                    }
                    break;
                case "empty":
                    hashSet.clear();
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
