//미래를 보는 능력을 가짐 -> 사재기
//
//1. 연속된 N일 동안의 물건의 매매가를 예측하여 알고 있음
//2. 하루에 최대 1만큼 구입 가능
//3. 판매는 얼마든지 가능
//예를 들어 3일 동안의 매매가가 1,2,3이라면 처음 두 날에 원료를 구매하여 마지막 날에 팔면 3의 이익
//
//첫번째 줄에는 테스트 케이스 수 T
//각 테스트 케이스 별로 첫 줄에는 자연수 N이 주어짐
//둘째줄에는 각 날의 매매가를 나타내는 N개의 자연수들이 공백으로 구분되어 주어짐
//
//뒤에서부터 반복
//    가장 큰거를 max로 두고
//    현재 원소가 max보다 작으면 max-원소를 answer에 더해줌

import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int i=1; i<=t; i++) {
            int n = Integer.parseInt(br.readLine());
            String a = br.readLine();
            int[] ary = makeAry(n, a);

            int curMax = 0;
            long answer = 0;

            for(int j=n-1; j>0; j--) {
                curMax = Math.max(curMax, ary[j]);

                if(curMax >ary[j-1]) {
                    answer += curMax - ary[j-1];
                }
            }

            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }

    public static int[] makeAry(int n, String a) {
        StringTokenizer st = new StringTokenizer(a);
        int[] ary = new int[n];
        for(int i=0; i<n; i++) {
            ary[i] = Integer.parseInt(st.nextToken());
        }
        return ary;
    }
}