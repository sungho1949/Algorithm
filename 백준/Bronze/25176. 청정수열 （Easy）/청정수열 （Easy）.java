import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N; // 입력받는 정수
        N = Integer.parseInt(br.readLine());

        int count = 1;
        for(int i = 1; i <= N; i++) {
            count *= i;
        }
        System.out.println(count);
    }
}
