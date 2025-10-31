import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[N+2];

        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= N; i++) {
            dp[i] = dp[i-1] + dp[i-2]; //피보나치
        }

        long a = 2*(dp[N] + dp[N-1]);
        System.out.println(a);
    }
}
