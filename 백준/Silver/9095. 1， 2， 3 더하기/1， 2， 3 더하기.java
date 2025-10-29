import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dp = new int[11];
        dp[1] = 1; // 1
        dp[2] = 2; // 1+1, 2
        dp[3] = 4; // 1+1+1, 1+2, 2+1, 3

        for(int i = 4; i <= 10; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append('\n');
        }

        System.out.println(sb);

    }
}
