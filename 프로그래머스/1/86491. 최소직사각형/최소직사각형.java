// 문제 설명
    // 모든 명함의 가로 길이와 세로 길이를 나타내는 2차원 배열 sizes가 주어짐
    // 모든 명함을 수납할 수 있는 가장 작은 지갑의 크기를 return(int로)
// 제한 사항
    // sizes의 길이는 1이상 10,000이하
    // sizes의 원소는 [w,h] 형식
    // w는 가로, h는 세로
    // w와 h는 1 이상 1,000 이하의 자연수
// 브레인스토밍
    // w를 넣을 배열, h를 넣을 배열을 만들어줌
    // for문을 sizes의 length만큼 돌림
        // Math.max를 이용해서 sizes[i][0], sizes[i][1]을 비교해서 더 큰걸 int[] w에 삽입, 작은걸 int[] h에 삽입
    // for문을 이용해서 w에서 가장 큰 값을 구함
    // for문을 이용해서 h에서 가장 큰 값을 구함
    // 두 값을 곱해서 return

import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        // w를 넣을 배열, h를 넣을 배열을 만들어줌
        List<Integer> wList = new ArrayList<>();
        List<Integer> hList = new ArrayList<>();
        
        // for문을 sizes의 length만큼 돌림
        for(int i=0; i<sizes.length; i++) {
            // Math.max를 이용해서 sizes[i][0], sizes[i][1]을 비교
            int w = sizes[i][0];
            int h = sizes[i][1];
            int bigger = Math.max(w,h);
            int smaller = Math.min(w,h);
            // 더 큰걸 int[] w에 삽입, 작은걸 int[] h에 삽입
            wList.add(bigger);
            hList.add(smaller);
        }
        
        // for문을 이용해서 w에서 가장 큰 값을 구함
        int maxW = wList.get(0);
        for(int i=1; i<wList.size(); i++) {
            maxW = Math.max(maxW, wList.get(i));
        }
        
        // for문을 이용해서 h에서 가장 큰 값을 구함
        int maxH = hList.get(0);
        for(int i=1; i<hList.size(); i++) {
            maxH = Math.max(maxH, hList.get(i));
        }
        // 두 값을 곱해서 return
        return maxW * maxH;
    }
}