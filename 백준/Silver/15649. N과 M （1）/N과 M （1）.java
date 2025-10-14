import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int N, M;
    static int[] arr; // N개의 숫자를 담을 배열
    static boolean[] visited; // 1부터 N까지 숫자 방문 여부 체크
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        visited = new boolean[N + 1]; // 

        dfs(0);
        System.out.println(sb);

    }

    public static void dfs(int depth) {
        if(depth == M) {
            for(int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = i;

                dfs(depth + 1);

                visited[i] = false;
            }
        }
    }
}
