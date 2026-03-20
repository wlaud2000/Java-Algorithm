import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int i = 0;
        while(i < n) {
            st = new StringTokenizer(br.readLine());
            String token = st.nextToken();

            switch (token) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    sb.append(stack.empty() ? -1 : stack.pop()).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    sb.append(stack.empty() ? 1 : 0).append("\n");
                    break;
                case "top":
                    sb.append(stack.empty() ? -1 : stack.peek()).append("\n");
                    break;
            }
            i++;
        }
        System.out.println(sb);
    }

    // 자바에서 제공하는 Stack 자료구조 사용하면 쉬운 문제
}
