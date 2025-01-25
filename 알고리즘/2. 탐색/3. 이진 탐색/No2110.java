import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException{
        // 집의 개수 N, 공유기 개수 C 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        // 집의 좌표 입력 받기
        int[] houses = new int[N];
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            houses[i] = Integer.parseInt(st.nextToken());
        }

        // 집의 개수가 최대 200_000이고 시간 제한이 2초(2억번)이므로
        // O(N^2)로는 풀 수 없다.
        // 좌표의 최대 거리는 1_000_000_000이므로
        // 이진 탐색을 이용하면
        // O(Nlog최대거리) -> 200_000 * 30 = 6_000_000번만에 가능하다.
        // 또한 이진 탐색을 이용하기 위해서는 정렬된 좌표가 필요한데
        // O(nlogn)의 시간복잡도를 가져야 한다.

        // 여기서는 자바의 Arrays.sort()를 사용할 것이다.
        // 집 좌표 정렬하기 -> 인접한 두 공유기 사이의 거리를 측정해야 한다.
        Arrays.sort(houses);

        // 최소거리 ~ 최대거리 이진 탐색
        // 최소거리(start), 최대거리(end), 결과값 정의
        int start = 1;
        int end = houses[N-1] - houses[0];
        int result = 0;
        // 최소거리 <= 최대거리까지 반복
        while (start <= end){
            // 중앙값, 공유기 설치 개수(첫 집에 설치), 설치한 마지막 집 정의
            int mid = (start + end) / 2;
            int count = 1;
            int lasthouse = houses[0];
            // N번 반복해 공유기 설치 개수가 만족하거나 그 이상인지 확인
            for (int i = 0; i < N; i++){
                // 만약 이후 집과의 거리가 mid값보다 같거나 크면 설치
                if (houses[i] - lasthouse >= mid){
                    count++;
                    lasthouse = houses[i];
                }
            }
            // 설치개수가 같거나 더 많으면 거리 증가
            if (count >= C){
                result = mid;
                start = mid + 1;
            }
            // 미만이면 거리 감소
            else{
                end = mid - 1;
            }
        }
        // 공유기 개수 C가 설치되었을 때, 두 공유기 사이의 최대 거리 출력
        System.out.println(result);
    }
}
