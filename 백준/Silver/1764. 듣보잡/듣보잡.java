import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // N,M 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // N 만큼 반복해서 듣도못한 사람을 HashSet에 저장 (비교하기 위해서 존재 여부 조회가 O(1)인 HashSet 사용. HashMap 써도 상관없긴한데 굳이?)
        HashSet<String> hashSet = new HashSet<>();
        for (int i=0; i<N; i++) {
            hashSet.add(br.readLine());
        }

        // M 만큼 반복해서 보도못한 사람과 듣도못한 사람을 비교. 같다면 ArrayList<String> result에 저장
        ArrayList<String> result = new ArrayList<>();
        for (int i=0; i<M; i++) {
            String name = br.readLine();
            if (hashSet.contains(name)) {
                result.add(name);
            }
        }

        // 정렬해주고 출력
        Collections.sort(result);
        
        int size = result.size();
        System.out.println(size);
        for (int i=0; i<size; i++) {
            System.out.println(result.get(i));
        }

    }
}
