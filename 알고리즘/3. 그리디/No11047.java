import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 동전 종류 N, 가격 K, 카운트
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count = 0;
        int[] tokens = new int[N];
        // N 개의 동전 가격 받기
        for (int i = N-1; i >= 0; i--){
            st = new StringTokenizer(br.readLine());
            tokens[i] = Integer.parseInt(st.nextToken());
        }

        // 0원이 될 때까지 반복
        while (K > 0){
            // 동전 배열 값이 K보다 작으면 count++, K-배열 인덱스
            for(int i = 0; i < N; i++){
                if (K >= tokens[i]){
                    count++;
                    K -= tokens[i];
                    i--;
                }
            }
        }
        // 카운트 출력
        System.out.println(count);
    }
}
