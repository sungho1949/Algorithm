import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] levels = new int[N];

        long minLevel = Integer.MAX_VALUE;

        for(int i = 0; i < N; i++) {
            levels[i] = Integer.parseInt(br.readLine());
            minLevel = Math.min(minLevel, levels[i]);
        }

        long left = minLevel;
        long right = minLevel + K;

        long ans = 0;

        while(left <= right) {
            long mid = (left + right) / 2;

            long sum = 0;

            for(int level : levels) {
                if(level < mid) {
                    sum += (mid - level);
                }
            }

            if(sum <= K) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(ans);
    }
}
