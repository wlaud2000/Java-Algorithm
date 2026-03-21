import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result;

        String a = br.readLine();
        if (!a.equals("FizzBuzz") && !a.equals("Fizz") && !a.equals("Buzz")) {
            result = Integer.parseInt(a) + 3;
            if (result % 15 == 0) {
                System.out.println("FizzBuzz");
            } else if (result % 3 == 0) {
                System.out.println("Fizz");
            } else if (result % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(result);
            }
        } else {
            String b = br.readLine();
            if (!b.equals("FizzBuzz") && !b.equals("Fizz") && !b.equals("Buzz")) {
                result = Integer.parseInt(b) + 2;
                if (result % 15 == 0) {
                    System.out.println("FizzBuzz");
                } else if (result % 3 == 0) {
                    System.out.println("Fizz");
                } else if (result % 5 == 0) {
                    System.out.println("Buzz");
                } else {
                    System.out.println(result);
                }
            } else {
                String c = br.readLine();
                result = Integer.parseInt(c) + 1;
                if (result % 15 == 0) {
                    System.out.println("FizzBuzz");
                } else if (result % 3 == 0) {
                    System.out.println("Fizz");
                } else if (result % 5 == 0) {
                    System.out.println("Buzz");
                } else {
                    System.out.println(result);
                }
            }
        }
    }
}