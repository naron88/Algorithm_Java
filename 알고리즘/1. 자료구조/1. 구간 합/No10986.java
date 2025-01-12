import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        long arr[] = new long[N+1];
        long count = 0;
        long remains[] = new long[M];

        arr[0] = 0;
        for (int i = 1; i <= N; i++) {
            arr[i] = arr[i-1] + sc.nextLong();
        }

        for (int i = 1; i <= N; i++) {
            int remain = (int)(arr[i] % M);
            if (remain == 0) {
                count++;
            }
            remains[remain]++;
        }

        for (int i = 0; i < M; i++) {
            if (remains[i] > 1){
                count += remains[i] * (remains[i]-1) / 2;
            }
        }
        System.out.println(count);
    }
}
