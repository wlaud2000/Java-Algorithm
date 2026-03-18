import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String text = br.readLine();

        while(!text.equals(".")) {
            Stack<Character> stack = new Stack<>();
            char[] ctext = text.toCharArray();
            boolean result = true;
            for(char now : ctext) {
                if (now == '(') {
                    stack.push((now));
                } else if (now == '[') {
                    stack.push(now);
                } else if (now == ')') {
                    if (stack.empty()) {
                        result = false;
                        break;
                    }
                    char check = stack.pop();
                    if (check != '(') {
                        result = false;
                        break;
                    }
                } else if (now == ']') {
                    if (stack.empty()) {
                        result = false;
                        break;
                    }
                    char check = stack.pop();
                    if (check != '[') {
                        result = false;
                        break;
                    }
                }
            }
            if (result == true && stack.empty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
            text = br.readLine();
        }
    }
}
