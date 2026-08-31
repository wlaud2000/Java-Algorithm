// 문제 설명
    // 체육복을 최대한 많은 학생이 빌리게 해야함. 자기 번호로 부터 앞 뒤 학생들한테만 빌려줄수있음
    // 전체 학생의 수 n, 체육복 도난당한 학생 배열 int[] lost, 여벌 체육복 가진 학생 배열 int[] reserve
    // 체육수업을 들을 수 있는 학생의 최댓값을 return 하라!
// 제한 사항
    // n은 2 이상 30 이하
    // 도난당한 학생수는 1 이상 n명 이하이고 중복 번호 없음
    // 여벌 체육복 있는 학생은 1명 이상 n명 이하이고 중복 번호 없음
    // 여벌 체육복이 있는 학생이 체육복 도난 당할수도 있음 그럼 못빌려주는거임.
// 브레인스토밍
    // [유형 판단]
    // 여벌 학생마다 앞/뒤/안줌 3가지 선택 → 3^(여벌 수) 완전탐색 가능 (n≤30이라 안 터짐)
    // 그리디로 O(n)에 해결 가능
    // 그리디 근거: 앞번호 여벌은 이미 지나온 자리라 지금 안 쓰면 영영 안 쓰임
    //             뒷번호 여벌은 다음 학생도 쓸 수 있는 공용 자원이라 아껴둘 가치가 있음
    //             → 나만 쓸 수 있는 것부터 소진하는 게 항상 이득


    // [0단계] 여벌 있는데 도난도 당한 학생 먼저 처리
        // lost에도 있고 reserve에도 있는 번호는 → 자기가 입음. 빌려줄 수도, 빌릴 수도 없음
        // 이 학생들을 lost와 reserve 양쪽에서 모두 제거해야 함
        // (이걸 안 하면 자기 여벌을 옆 사람한테 줘버리는 오답이 나옴)

    // [1단계] 앞번호부터 순서대로 짝지어주기
        // lost와 reserve를 오름차순 정렬
        // lost를 앞에서부터 순회
            // 해당 학생 번호 - 1 이 reserve에 있으면 → 빌림 성공, reserve에서 제거
            // 없으면 번호 + 1 이 reserve에 있는지 확인 → 있으면 빌림 성공, reserve에서 제거
            // 둘 다 없으면 이 학생은 수업 못 들음

    // [2단계] 정답 계산

import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        // 0단계
        // 각 학생이 가진 체육복 개수 담은 배열
        int[] clothes = new int[n+1];
        
        for(int i=1; i<=n; i++) {
            clothes[i] = 1;
        }
        
        for(int l : lost) {
            clothes[l]--;
        }
        
        for(int r : reserve) {
            clothes[r]++;
        }
        
        // 1단계
        // 앞번호부터 처리
        for(int i=1; i<=n; i++) {
            // 옷 1벌 이상인 학생은 건너뜀
            if (clothes[i] != 0) {
                continue;
            }
            
            // 옷없는 학생의 앞번호 학생 먼저 확인
            if (i-1>=1 && clothes[i-1] == 2) {
                clothes[i-1]--;
                clothes[i]++;
            } 
            // 앞번호 학생이 없을 때 뒷번호 학생 확인
            else if (i+1<=n && clothes[i+1] == 2){
                clothes[i+1]--;
                clothes[i]++;
            }
        }
        
        int answer = 0;
        for(int i=1; i<=n; i++) {
            if (clothes[i]>=1) {
                answer++;
            }
        }
        
        return answer;
    }
}