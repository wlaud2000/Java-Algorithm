import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        // BR이랑 BW 선언 및 테스트 횟수인 T 저장
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        // Integer ArrayList 하나 만들어서 2번 인덱스부터 규칙대로 값을 add
        ArrayList<Integer> zeroAry = new ArrayList<>();
        zeroAry.add(1);
        zeroAry.add(0);
        for (int i=2; i<=40; i++) {
            zeroAry.add(zeroAry.get(i-2) + zeroAry.get(i-1));
        }

        // Integer ArrayList 하나 만들어서 2번 인덱스부터 규칙대로 값을 add
        ArrayList<Integer> oneAry = new ArrayList<>();
        oneAry.add(0);
        oneAry.add(1);
        for (int i=2; i<=40; i++) {
            oneAry.add(oneAry.get(i-2) + oneAry.get(i-1));
        }

        // T만큼 반복하며 답을 출력
        for (int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            bw.write(zeroAry.get(N) + " " + oneAry.get(N));
            bw.newLine();
        }
        bw.flush();

        br.close();
        bw.close();
    }
}
