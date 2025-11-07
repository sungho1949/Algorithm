import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] price = new int[N];
            // 케이스 하나 입력.
            for (int j = 0; j < N; j++) {
                price[j] = Integer.parseInt(st.nextToken());
            }

            int max = price[N - 1];
            long maxTotal = 0;
            // 1. 맨 뒷값에서 전값 비교
            for (int i = N - 2; i >= 0; i--) {
                // 맨 뒷값이 전값보다 작은 경우
                if (price[i] > max) {
                    max = price[i];
                }
                // 맨 뒷값이 전값보다 작지 않은 경우 -> 뺴고 더함
                else {
                    maxTotal += max - price[i];
                }
            }
            sb.append(maxTotal).append('\n');
        }
        System.out.println(sb.toString());
    }
}

