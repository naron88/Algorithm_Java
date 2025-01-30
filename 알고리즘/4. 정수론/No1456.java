import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력: start, end
        long start = Long.parseLong(st.nextToken());
        long end = Long.parseLong(st.nextToken());

        int count = 0;

        // 소수 판별 범위: 2 ~ sqrt(end)
        int max = (int) Math.sqrt(end);
        boolean[] isPrime = new boolean[max + 1];
        Arrays.fill(isPrime, true);

        // 에라토스테네스의 체를 사용하여 소수 구하기
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i <= Math.sqrt(max); i++) {
            if (isPrime[i]) {
                // i * i의 이전 배수는 이미 이전에 끝남
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // 소수의 제곱 계산
        for (int i = 2; i <= max; i++) {
            if (isPrime[i]) {
                // 소수의 제곱
                long power = (long) i * i;
                while (power <= end) {
                    if (power >= start) {
                        count++;
                    }
                    // 오버플로우 방지
                    if (power > end / i) break;
                    power *= i;
                }
            }
        }
        System.out.println(count);
    }
}
