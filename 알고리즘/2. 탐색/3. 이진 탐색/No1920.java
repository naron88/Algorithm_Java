import java.io.*;
import java.util.*;

public class No1920 {
    // 원하는 정수 찾기
    // 1920
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 숫자 개수 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        // 숫자 입력 받기
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(arr);

        // 찾아야 할 숫자 개수
        st = new StringTokenizer(br.readLine());
        int findN = Integer.parseInt(st.nextToken());

        // 찾을 숫자
        int[] findArr = new int[findN];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<findN; i++){
            findArr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<findN; i++){
            int start = 0;
            int end = N-1;
            int result = 0;
            // 이진 탐색 (nlogn)
            while(start <= end){
                int mid = (start+end)/2;
                if(arr[mid] == findArr[i]){
                    result = 1;
                    break;
                }
                else if(arr[mid] > findArr[i]){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
    }
}