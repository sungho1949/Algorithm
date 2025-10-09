import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 불! - 시작점이 두 종류(같은 것이 여러개와 종류가 여러 개는 다름) + 객체 사용
public class Main {
    static int r, c;
    static char[][] map;
    static Queue<Point> jq = new LinkedList<>();
    static Queue<Point> fq = new LinkedList<>();
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static class Point {
        int x, y, time;

        Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];

        for(int i = 0; i < r; i++) {
            String line = br.readLine();
            for(int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
                if(map[i][j] == 'J') {
                    jq.offer(new Point(i, j, 0)); // 지훈이 위치 jq 저장
                } else if (map[i][j] == 'F') {
                    fq.offer(new Point(i, j, 0)); // 불 위치 fq에 저장
                }
            }
        }

        int result = bfs();

        if(result == -1) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println(result);
        }
    }

    public static int bfs() {
        while(!jq.isEmpty()) {
            int fireSize = fq.size();
            for(int i = 0; i < fireSize; i++) {
                Point nowFire = fq.poll();

                for(int j = 0; j < 4; j++) { // 불 이동 경로
                    int nx = nowFire.x + dx[j];
                    int ny = nowFire.y + dy[j];

                    if(nx >= 0 && nx < r && ny >= 0 && ny < c) {
                        if(map[nx][ny] == '.' || map[nx][ny] == 'J') {
                            map[nx][ny] = 'F';
                            fq.offer(new Point(nx, ny, 0));
                        }
                    }
                }
            }

            int jihunSize = jq.size();
            for(int i = 0; i < jihunSize; i++) {
                Point nowJihun = jq.poll();

                if(nowJihun.x == 0 || nowJihun.x == r - 1 || nowJihun.y == 0 || nowJihun.y == c -1) {
                    return nowJihun.time + 1;
                }

                for(int j = 0; j < 4; j++) {
                    int nx = nowJihun.x + dx[j];
                    int ny = nowJihun.y + dy[j];

                    if(nx >= 0 && nx < r && ny >= 0 && ny < c) {
                        if(map[nx][ny] == '.') {
                            map[nx][ny] = 'J';
                            jq.offer(new Point(nx, ny, nowJihun.time + 1));
                        }
                    }
                }
            }
        }
        return -1;
    }
}
