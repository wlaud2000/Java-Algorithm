import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Integer> ary = new ArrayList<>();

        ary.add(0);
        ary.add(1);
        ary.add(2);
        ary.add(4);

        for (int i=4; i <=10; i++) {
            ary.add(ary.get(i-3) + ary.get(i-2) + ary.get(i-1));
        }

        int t = Integer.parseInt(br.readLine());

        for (int i=0; i<t; i++) {
            int num = Integer.parseInt(br.readLine());
            bw.write(ary.get(num) + "\n");
        }
        bw.flush();

        br.close();
        bw.close();
    }
}
