import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 아파트 인원 수를 담을 2차원배열
        int[][] arr = new int[15][15];

        // 1호실은 다 1로, 0층은 i로 선언
        for (int i=0; i<15; i++) {
            arr[i][1] = 1;
            arr[0][i] = i;
        }

        // 나머지 호도 다 채움
        for (int i=1; i<15; i++) {
            for (int j=2; j<15; j++) {
                arr[i][j] = arr[i][j-1] + arr[i-1][j];
            }
        }

        int T = Integer.parseInt(br.readLine());

        // 출력
        for (int i=0; i<T; i++) {
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(arr[a][b]));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
