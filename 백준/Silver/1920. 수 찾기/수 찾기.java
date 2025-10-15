import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 이분 탐색 정렬필요
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        //StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            System.out.println(binarySearch(target));
        }

       // System.out.println(sb);
    }

    //binarySearch
    public static int binarySearch(int target) {
        int low = 0;
        int high = arr.length - 1;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(arr[mid] == target) {
                return 1;
            } else if(arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 0;
    }
}
