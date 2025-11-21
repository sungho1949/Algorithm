import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long M; // 필요한 나무 길이
        int N; // 나무 개수

        // 나무 갯수 , 최소 길이
        N = (int)Long.parseLong(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 나무 길이까지 입력
        int[] T = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            T[i] = Integer.parseInt(st.nextToken());
        }

        int min = 0;
        int max = 0;

        for (int i = 0; i < N; i++) {
            max = Math.max(max, T[i]);
        }

        while (min < max) {
            long sum = 0; // 잘린 나무 합
            int H = (min + max) / 2;
            // sum 구하기
            for (int i = 0; i < N; i++) {
                if (T[i] > H) {
                    sum += T[i] - H;
                }
            }

            // sum이 M보다 작을 때
            if (sum < M) {
                max = H;
            } else {
                min = H + 1;
            }

        }
        System.out.println(min - 1);
    }
}
