import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int N; // 과일 갯수
        int L; // 새 길이

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        int[] h = new int[N];

        // 과일들 높이
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }

        // 과일 정렬
        Arrays.sort(h);

        for(int i = 0; i < N; i++) {
            // 높이가 새의 길이보다 작다면 새 길이 +1
            if(h[i] <= L) {
                L += 1;
            }
        }
        System.out.println(L);
    }
}
