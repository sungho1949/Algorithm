import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int m, n, k;
    static int[][] field;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for(int a = 0; a < t; a++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            field = new int[n][m];
            visited = new boolean[n][m];

            // 배추 위치 입력 받기
            for(int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                field[x][y] = 1;
            }

            int worm = 0; // 지렁이 수

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(field[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        worm++;
                    }
                }
            }
            System.out.println(worm);
        }
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q= new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if(nx >= 0 && nx < n && ny >= 0 && ny <m) {
                    if (field[nx][ny] == 1 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
