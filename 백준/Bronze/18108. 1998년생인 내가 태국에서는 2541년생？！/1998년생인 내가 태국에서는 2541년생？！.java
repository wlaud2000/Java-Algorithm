import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine(); //한 줄 읽고 문자열로 반환
        int year = Integer.parseInt(s); //반환 된 문자열을 정수로 바꾼다.
        
        System.out.println(year - 543);
    }
}