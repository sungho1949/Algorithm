import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-2,-1,-2,-1,1,2,1,2}; // 나이트 이동할 수 있는 곳
    static int[] dy = {1,2,-1,-2,2,1,-2,-1};
    static int l; // 체스판 크기
    static int[][] board;
    static int startX, startY, endX, endY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        for(int t = 0; t < T; t++) { //각 테스트 케이스 입력을 받아야뎀
            l = Integer.parseInt(br.readLine());
            board = new int[l][l]; // 하나의 테스트 board

            StringTokenizer st = new StringTokenizer(br.readLine());
            // 시작 위치
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());
            // 끝 위치
            st = new StringTokenizer(br.readLine());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());

            // 시작 위치 끝 위치 같을 때
            if(startX == endX && startY == endY) {
                System.out.println(0);
                continue;
            }


            bfs();
        }
    }

    public static void bfs() {
        // 큐 선언
        Queue<int[]> q = new LinkedList<>();
        // 큐에 첫 위치 넣기
        q.offer(new int[]{startX, startY});
        //큐가 빌 때 까지 반복 -> 뭘? 이제 계산을 해야뎀
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            // 방향 별 탐색
            for(int i = 0; i < 8; i++) {
                int nx = curX + dx[i];
                int ny = curY + dy[i];

                // 범위를 넘어가는거 제외
                if(nx < 0 || ny < 0 || nx >= l || ny >= l) {
                    continue;
                }
                // 방문 X
                if(board[nx][ny] == 0) {
                    board[nx][ny] = board[curX][curY] + 1;

                    // 만약 다음 가는 곳이 도착점이라면 출력 및 종료
                    if(nx == endX && ny == endY) {
                        System.out.println(board[nx][ny]);
                        return;
                    }

                    q.offer(new int[]{nx,ny});
                }
            }
        }
    }
}
