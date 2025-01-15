import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 수 N, M 입력받기
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long count = 0;

        // N개의 수 입력 받기
        // 합 배열 만들기
        long[] sumArr = new long[N+1];
        long[] mCount = new long[M];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            sumArr[i] = sumArr[i-1] + Long.parseLong(st.nextToken());

            // 1. 구간 합 % M == 0 인 경우 구하기
            if (sumArr[i] % M == 0){
                count++;
            }
            mCount[(int)(sumArr[i] % M)]++;
        }

        // 2. 구간합 A % M - B % M == 0 인 경우 구하기
        //      nC2 = n * (n-1) / 2
        for (int i = 0; i < M; i++) {
            if (mCount[i] > 1){
                count += mCount[i] * (mCount[i] - 1) / 2;
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
    }
}
