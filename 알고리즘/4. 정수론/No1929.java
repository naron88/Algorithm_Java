import java.io.*;
import java.util.*;

public class No1929 {
    // 소수 구하기
    // 1929
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // 배열 생성
        boolean[] isPrime = new boolean[end +1];
        for(int i = 2; i <= end; i++){
            isPrime[i] = true;
        }

        // 1을 false로
        isPrime[1] = false;

        // end의 제곱근 만큼 반복
        for(int i = 2; i <= Math.sqrt(end); i++){
            // true일 때 반복
            if(isPrime[i]){
                // 소수가 아닌 수 제거
                for(int j = i + i; j <= end; j += i){
                    isPrime[j] = false;
                }
            }
        }
        // 출력
        for(int i = start; i <= end; i++){
            if(isPrime[i]){
                bw.write(i + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
