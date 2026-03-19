import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++) {
            String text = br.readLine();
            // char 배열에 넣어줌
            char [] ctext = text.toCharArray();
            // 괄호들 넣어 줄 스택 생성
            Stack<Character> stack = new Stack<>();
            boolean result = true;

            for (char now : ctext) {
                if (now == '(') {
                    stack.push(now);
                } else if (now == ')') {
                    // 스택 비어있는지 체크 먼저
                    if (stack.empty()) {
                        result = false;
                        break;
                    }
                    // 비어있지 않으면 stack pop
                    stack.pop();
                }
            }
            // 한 줄 다 읽었을 때 Stack이 비어있지 않으면 false
            if (!stack.empty()) {
                result = false;
            }
            if (!result) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }

    }
}
