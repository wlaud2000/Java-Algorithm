// 1번 수포자 : 1,2,3,4,5 반복
// 2번 수포자 : 2,1, 2,3, 2,4, 2,5 반복
// 3번 수포자 : 3,3, 1,1, 2,2, 4,4, 5,5 반복
// 정답 순서대로 들은 배열 answers 주어짐, 가장 많은 문제를 맞힌 사람이 누구인가?
// 시험은 최대 10,000문제
// 동점일 경우 오름차순으로 정렬

import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        
        // 맞춘 개수를 담을 배열
        int[] score = new int[3];
        
        for(int i=0; i<answers.length; i++) {
            if(answers[i] == one[i%5]) {
                score[0]++;
            } 
            
            if(answers[i] == two[i%8]) {
                score[1]++;
            } 
            
            if(answers[i] == three[i%10]) {
                score[2]++;
            }
        }
        
        int max = Math.max(score[0], (Math.max(score[1], score[2])));
        
        List<Integer> result = new ArrayList<>();
        
        for(int i=0; i<score.length; i++) {
            if(score[i]==max) {
                result.add(i+1);
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}