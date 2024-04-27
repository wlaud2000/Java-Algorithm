import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main{
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str," "); 
        int A = Integer.parseInt(st.nextToken()); //구분자로 구분된 문자열이 담긴 변수를 꺼냄, 문자열은 꺼내짐과 동시에 해당객체에서 사라짐
        int B = Integer.parseInt(st.nextToken()); //꺼낸 문자열을 정수형으로 변환하는 Interger.parseInt()사용 후 정수형 변수에 넣고 저장
        
        System.out.println(A+B);
    }
}