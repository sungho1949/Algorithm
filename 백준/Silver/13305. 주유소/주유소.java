import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 도시 갯수

        Long[] dis= new Long[N-1]; // 거리
        Long[] price = new Long[N]; // 지역 당 기름가격

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 거리 입력
        for(int i = 0; i < N-1; i++) {
            dis[i] = Long.parseLong(st.nextToken());
        }

        //지역 당 기름 가격 입력
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            price[i] = Long.parseLong(st.nextToken());
        }

        // 맨 처음 기름 가격이 최소인지?
        long min = price[0];
        long total = 0;
        for(int i = 0; i < N-1; i++) {
            if(min > price[i]) {
                min = price[i];
            }
            total += min * dis[i];
        }

        System.out.println(total);
    }
}
