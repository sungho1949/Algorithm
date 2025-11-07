import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 입력
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        Integer[] B = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        // A 입력
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // B 입력
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        // 아이디어 B의 가장 큰 값을 A의 가장 작은 값으로 계산. 그러면 S는 최소값.
        // 그러면 a를 오름차순, B를 내림차순으로 계산하면 끝?

        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        int S = 0;
        for(int i = 0; i < N; i++) {
            S += A[i]*B[i];
        }

        System.out.println(S);
    }
}
