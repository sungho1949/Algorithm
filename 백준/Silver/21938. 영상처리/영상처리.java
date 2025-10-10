import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] image;
    static boolean[][] visited;
    static int T; // 경계
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        image = new int[N][M];
        visited = new boolean[N][M];


        //입력
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                int R = Integer.parseInt(st.nextToken());
                int G = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                // 평균값
                image[i][j] = (R + G + B) / 3;
            }
        }

        // 경계
        T = Integer.parseInt(br.readLine());

        // T <= image[][] --> 255 , T > image[i][j] --> 0
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if (image[i][j] >= T) {
                    image[i][j] = 255;
                } else {
                    image[i][j] = 0;
                }
            }
        }

        //변환된 image를 가지고 물체 개수
        int count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                //image[i][j] == 1 && !visited[i][j]
                if(image[i][j] == 255 && !visited[i][j]) {
                    count++;
                    bfs(i, j);
                }
            }
        }
        System.out.println(count);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        // 큐에서 값을 빼야뎀 -> 뺀 값 저장
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            // 이동
            for(int i = 0; i < 4; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];



                if(nx >= 0 && nx < N && ny >= 0 && ny <M){
                    if(!visited[nx][ny] && image[nx][ny] == 255){
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx,ny});
                    }
                }

            }

        }
    }
}
