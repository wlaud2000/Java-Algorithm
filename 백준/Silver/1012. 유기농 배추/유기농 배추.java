import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int answer;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());

            int[][] maps = new int[n][m];
            boolean[][] visited = new boolean[n][m];
            answer = 0;

            // 맵 만들기
            for(int i=0; i<a; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                maps[x][y] = 1;
            }

            // dfs로 maps 랑 visited 넘겨서 왼쪽 위부터 상하좌우 탐색
            for(int i=0; i<n; i++) {
                for(int j=0; j<m; j++) {
                    if(maps[i][j] == 1 && !visited[i][j]) {
                        visited[i][j] = true;
                        dfs(maps, visited, i, j, n, m);
                        answer++;
                    }
                }
            }
            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int[][] maps, boolean[][] visited, int x, int y, int n, int m) {

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || nx>=n || ny<0 || ny>=m) continue;

            if(maps[nx][ny] == 1 && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(maps, visited, nx, ny, n, m);
            }
        }
    }
}
