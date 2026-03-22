import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Deque<Integer> queue = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        int i = 0;
        while(i<N) {
            st = new StringTokenizer(br.readLine());
            String token = st.nextToken();

            switch (token) {
                case ("push") :
                    queue.offerLast(Integer.parseInt(st.nextToken()));
                    break;
                case ("pop") :
                    if (queue.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        int target = queue.pollFirst();
                        bw.write(target + "\n");
                    }
                    break;
                case ("size") :
                    bw.write(queue.size() + "\n");
                    break;
                case ("empty") :
                    bw.write((queue.isEmpty() ? 1 : 0) + "\n");
                    break;
                case ("front") :
                    if (queue.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        int target = queue.peekFirst();
                        bw.write(target + "\n");
                    }
                    break;
                case ("back") :
                    if (queue.isEmpty()) {
                        bw.write("-1\n");
                    } else {
                        int target = queue.peekLast();
                        bw.write(target + "\n");
                    }
                    break;
            }
            i++;
        }
        bw.flush();
        bw.close();
    }
}
