import java.io.*;
import java.util.StringTokenizer;

public class No11659 {
    public static void main(String[] args) throws IOException {
        // 구간 합 구하기
        // 11659
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 숫자의 개수
        int numCount = Integer.parseInt(st.nextToken());
        // 구간 합 횟수
        int frequency = Integer.parseInt(st.nextToken());

        // 숫자의 개수만큼 배열 생성
        int[] arr = new int[numCount+1];
        // 숫자 받기
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= numCount; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 합 배열 만들기
        int[] sumArr = new int[numCount+1];
        sumArr[1] = arr[1];
        for(int i = 1; i <= numCount; i++){
            sumArr[i] = sumArr[i-1] + arr[i];
        }

        // 구간합 횟수만큼 반복
        for(int i = 0; i < frequency; i++) {
            // 범위 받기
            st = new StringTokenizer(br.readLine());
            int iNum = Integer.parseInt(st.nextToken());
            int jNum = Integer.parseInt(st.nextToken());

            // 계산 및 출력
            // 구간합 계산식
            int result = sumArr[jNum] - sumArr[iNum - 1];
            bw.write(result + "\n");
            bw.flush();
        }
    }
}