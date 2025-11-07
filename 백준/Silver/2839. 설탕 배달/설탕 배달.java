import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력받기
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        // 1. 5로 먼저 N 계산.
        // 2. 차이를 3으로 계산.
        while(N >= 0) {
            // 5로 나누었을 때 0으로 떨어지는 경우
            if(N % 5 == 0) {
                count += N/5;
                System.out.println(count);
                return;
            } else {
                N -= 3;
                count++;
            }
        }

        // 5,3으로 계산이 안되는경우
        System.out.println(-1);

    }
}
