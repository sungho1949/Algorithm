import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N; // 운동 기구 갯수 -> 운동 일수
    static int K; // 하루마다 감소하는 중량
    static boolean[] visited; // 운동 기구 썻는지 안썻느지
    static int[] h; // 운동 기구
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        h = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        // 운동 기구 중량
        for(int i = 0; i < N; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }
        // 백트래킹
        backtracking(0, 500);
        System.out.println(count);
    }

    public static void backtracking(int day, int w) {
        if(day == N) {
            count++;
            return;
        }

        // 운동기구 하나씩
        for(int i = 0; i < N; i++) {
            // 아직 사용 X
            if(!visited[i]) {
                int next = w + h[i] - K;
                if(next >= 500) {
                    visited[i] = true;
                    backtracking(day+1, next);
                    visited[i] = false;
                }
            }
        }
    }
}
