import java.util.*;

class Solution {

    // 각 스테이지 번호별로 보유한 힌트권 장수를 저장
    // key = 스테이지 번호(1-based), value = 그 번호의 힌트권 보유 장수
    // 모든 재귀 분기가 이 map 하나를 공유하므로 반드시 원복 필요
    HashMap<Integer, Integer> map = new HashMap<>();

    int n;                            // 전체 스테이지 개수
    int answer = Integer.MAX_VALUE;   // 최솟값을 찾는 문제 → 최댓값으로 초기화

    public int solution(int[][] cost, int[][] hint) {
        n = cost.length;              // n 초기화 필수 (안 하면 0이라 즉시 종료됨)
        dfs(cost, hint, 1, 0);        // 1번 스테이지부터, 누적비용 0으로 시작
        return answer;
    }

    // stage : 지금 풀어야 할 스테이지 번호 (1-based)
    // sum   : stage 직전까지 확정된 누적 비용
    void dfs(int[][] cost, int[][] hint, int stage, int sum) {

        // ===== 종료 조건 =====
        // stage > n 이어야 함. stage == n 으로 하면 마지막 스테이지 비용을 안 더하고 나감
        // 여기 도착한 sum은 모든 선택이 끝난 "완성된 총비용"이라 그대로 후보가 됨
        if (stage > n) {
            answer = Math.min(answer, sum);
            return;
        }

        // 모든 비용이 0 이상이라 sum은 앞으로 절대 줄지 않음
        // 이미 answer 이상이면 이 서브트리의 어떤 결과도 답이 될 수 없음
        if (sum >= answer) return;

        // ===== 현재 스테이지 해결 =====
        // 보유 장수는 중복 힌트권 때문에 n을 넘길 수 있음
        // 실제 사용 가능 장수는 최대 n-1 (= cost[i]의 마지막 인덱스)
        // cost[i][j] > cost[i][j+1] 이므로 쓸 수 있는 만큼 다 쓰는 게 항상 이득
        int value = Math.min(map.getOrDefault(stage, 0), n - 1);

        // 해결 비용은 번들 구매 여부와 무관하게 무조건 지불 → 분기 전에 더함
        sum += cost[stage - 1][value];

        // ===== 마지막 스테이지 =====
        // n번 스테이지에서는 번들을 팔지 않으므로 바로 종료로 넘어감
        if (stage == n) {
            dfs(cost, hint, stage + 1, sum);
            return;
        }

        // ===== 분기 1: 번들을 사지 않는다 =====
        dfs(cost, hint, stage + 1, sum);

        // ===== 분기 2: 번들을 산다 =====
        int[] a = hint[stage - 1];   // a[0] = 판매 가격, a[1..] = 힌트권 번호들

        // 힌트권 지급: 인덱스 0은 가격이므로 반드시 1부터 시작
        for (int i = 1; i < a.length; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }

        // 번들 가격 a[0]을 더하고 다음 스테이지로
        dfs(cost, hint, stage + 1, sum + a[0]);

        // 백트래킹 원복: 이 층에서 더한 만큼 정확히 되돌림
        // 안 하면 위쪽 "안 산다" 분기가 이 힌트권을 물려받아
        // 돈은 안 내고 할인만 받는 잘못된 결과가 나옴
        for (int i = 1; i < a.length; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) - 1);
        }
    }
}