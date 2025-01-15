import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 수의 개수 N
        int N = Integer.parseInt(st.nextToken());

        // N개의 수 입력받기
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 정렬
        Arrays.sort(arr);

        // 다른 두개의 수의 합이 어떤 수를 나타낼 수 있으면 count++
        // 1번 index ~ N-1번 index까지 반복
        int count = 0;
        for (int i = 0; i < N; i++) {
            // 투포인터 사용 해서 계산
            int startPoint = 0;
            int endPoint = N-1;
            int target = arr[i];

            while (startPoint < endPoint){
                int sum = arr[startPoint] + arr[endPoint];

                // 투포인터 합이 같으면
                if (sum == target){
                    if(startPoint != i && endPoint != i){
                        // 두 포인터 모두 타겟 수와 다르면 count++, break;
                        count++;
                        break;
                    } else if (endPoint == i) {
                        // endPoint 가 타겟이랑 같으면 --;
                        endPoint--;
                    } else {
                        // startPoint가 같으면 ++;
                        startPoint++;
                    }
                }else if(sum > target){
                    // 합이 더 크면 endPoint--;
                    endPoint--;
                }else{
                    // 작으면 startPoint++;
                    startPoint++;
                }
            }
        }
        bw.write(count+ "\n");
        bw.flush();
        bw.close();
    }
}
