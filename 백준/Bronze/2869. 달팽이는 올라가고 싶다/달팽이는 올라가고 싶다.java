import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		long A = Long.parseLong(st.nextToken());
    long B = Long.parseLong(st.nextToken());
    long V = Long.parseLong(st.nextToken());
		// 여기까지는 맞았다 😅
		
		// 첫날 낮에 바로 정상 도달
        if (A >= V) {
            System.out.println(1);
            return;
        }

        // 첫날 이후 남은 거리를 하루 순이동으로 나눠서 계산
        long remaining = V - A;
        long daily = A - B;
        long cnt = 1 + (remaining + daily - 1) / daily;

        System.out.println(cnt);
	}
}