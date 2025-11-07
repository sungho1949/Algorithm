import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] meeting = new int[N][2]; // 회의 시간

        // 회의 시간 입력 후 정렬
        // 1. 입력
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meeting[i][0] = Integer.parseInt(st.nextToken());
            meeting[i][1] = Integer.parseInt(st.nextToken());
        }

        // 2. 정렬
        Arrays.sort(meeting, (o1,o2) -> {
                // 1. 종료 시간이 빠른 순서대로
                if(o1[1] == o2[1]) {
                    // 2. 시작 시간이 빠른 순서대로
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
        });

        int count = 0;
        int lastEndTime = 0;

        for(int i = 0; i < N; i++) {
            int startTime = meeting[i][0];
            int endTime = meeting[i][1];

            // 전체 회의 시작 시간이 이전 끝난 회의 종료 시간 이후
            if(startTime >= lastEndTime) {
                count++;
                lastEndTime = endTime;
            }
        }

        System.out.println(count);
    }
}
