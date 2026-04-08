import java.io.*;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        //PriorityQueue는 우선순위가 높은 게 먼저 나온다.
        // Java 기본 설정은 숫자가 작을수록 우선순위가 높다 → 최솟값이 항상 앞에 있다.
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();

        for (int i=0; i<n; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input > 0) {
                minQueue.add(input);
            } else {
                if (minQueue.isEmpty()) {
                    bw.write("0");
                    bw.newLine();
                } else {
                    bw.write(String.valueOf(minQueue.poll()));
                    bw.newLine();
                }
            }
        }
        bw.flush();

        br.close();
        bw.close();
    }
}
