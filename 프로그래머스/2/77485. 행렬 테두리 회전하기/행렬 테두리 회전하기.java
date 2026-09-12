import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        // 1부터 rows*columns까지 순서대로 채운 board 생성
        int[][] board = new int[rows][columns];
        int item = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = item;
                item++;
            }
        }

        int[] answer = new int[queries.length];

        // 쿼리 개수만큼 반복
        for (int q = 0; q < queries.length; q++) {
            // 좌상단(a,b), 우하단(c,d) 좌표 (1-indexed)
            int a = queries[q][0];
            int b = queries[q][1];
            int c = queries[q][2];
            int d = queries[q][3];

            int min = Integer.MAX_VALUE;

            // ---- 좌상단 값을 미리 저장 ----
            // 이 값은 회전 과정에서 곧바로 덮어써지므로,
            // 나중에 제자리(사실은 오른쪽 한 칸 자리)에 넣어주기 위해 미리 백업해둠
            int temp = board[a-1][b-1];
            min = Math.min(min, temp);

            // ---- 1단계: 왼쪽 열 (위 <- 아래 값 당겨오기) ----
            // r = a-1 ~ c-2 까지만 처리 (c-1까지 하면 범위 초과 + 좌하단을 미리 건드리게 됨)
            // 좌하단(board[c-1][b-1])은 다음 단계(아래 행)의 첫 실행에서 채워짐
            for (int r = a-1; r < c-1; r++) {
                board[r][b-1] = board[r+1][b-1];
                min = Math.min(min, board[r][b-1]);
            }

            // ---- 2단계: 아래 행 (왼쪽 <- 오른쪽 값 당겨오기) ----
            // col = b-1 ~ d-2 까지 처리
            // 첫 실행(col=b-1)에서 1단계가 남겨둔 좌하단 자리를 채움
            // 우하단(board[c-1][d-1])은 건드리지 않고 다음 단계로 넘김
            for (int col = b-1; col < d-1; col++) {
                board[c-1][col] = board[c-1][col+1];
                min = Math.min(min, board[c-1][col]);
            }

            // ---- 3단계: 오른쪽 열 (아래 <- 위 값 당겨오기 방향으로 진행하되, 실제로는 위→아래 복사) ----
            // r = c-1 ~ a+1 까지 처리 (r=a까지, a-1은 제외)
            // 첫 실행(r=c-1)에서 2단계가 남겨둔 우하단 자리를 채움
            // 우상단(board[a-1][d-1])은 건드리지 않고 다음 단계로 넘김
            for (int r = c-1; r > a-1; r--) {
                board[r][d-1] = board[r-1][d-1];
                min = Math.min(min, board[r][d-1]);
            }

            // ---- 4단계: 위쪽 행 (오른쪽 <- 왼쪽 값 당겨오기 방향으로 진행하되, 실제로는 왼→오 복사 반대) ----
            // col = d-1 ~ b+1 까지 처리 (col=b까지, b-1은 제외)
            // 첫 실행(col=d-1)에서 3단계가 남겨둔 우상단 자리를 채움
            // 마지막 실행(col=b)에서 board[a-1][b] 자리가 비게 됨 (원래 좌상단 값이 들어갈 자리)
            for (int col = d-1; col > b-1; col--) {
                board[a-1][col] = board[a-1][col-1];
                min = Math.min(min, board[a-1][col]);
            }

            // ---- 순환 완성: 처음 저장해둔 원래 좌상단 값을 마지막 빈자리에 채움 ----
            // 시계방향 회전이므로 좌상단 값은 오른쪽으로 한 칸([a-1][b] 자리) 이동해야 함
            board[a-1][b] = temp;

            answer[q] = min;
        }

        return answer;
    }
}