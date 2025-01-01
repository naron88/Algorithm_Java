import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1253 {
    public static void main(String[] args) throws IOException {
        // '좋은 수' 구하기
        // 1253
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 수의 개수
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numCount = Integer.parseInt(st.nextToken());

        // 좋은 수의 개수
        int count = 0;

        // 배열 생성 및 저장
        int[] arr = new int[numCount];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < numCount; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 배열 정렬
        Arrays.sort(arr);

        // 투포인터를 사용해 해결
        // 배열 모든 수에 대해 반복
        for(int k = 0; k < numCount; k++){
            // i, j 포인터를 사용
            int i = 0;
            int j = numCount-1;
            int target = arr[k];

            // 포인터가 만날 때까지 반복
            while(i < j){
                if(arr[i] + arr[j] == target){
                    // arr의 값이 k와 같지 않아야 좋은 수
                    if(i != k && j != k){
                        count++;
                        break;
                    }
                    else if(i == k){
                        i++;
                    }
                    else if(j == k){
                        j--;
                    }
                }
                else if(arr[i] + arr[j] < target){
                    i++;
                }
                else{
                    j--;
                }
            }
        }
        bw.write(count+"\n");
        bw.flush();
        bw.close();
    }
}