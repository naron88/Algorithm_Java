import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private static int[] arr;
    public static void main(String[] args) throws Exception{
        // 퀵 소트
        // 수 개수, 칮고자 하는 인덱스 값 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numCount = Integer.parseInt(st.nextToken());
        int findIndex = Integer.parseInt(st.nextToken());

        arr = new int[numCount];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numCount; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 퀵소트
        quickSort(0, numCount - 1);

        // 인덱스 출력
        bw.write(arr[findIndex - 1] + "");
        bw.flush();
        bw.close();
    }

    private static void quickSort(int start, int end){
        // start >= end면 종료
        if (start >= end) return;

        // 피벗, 피벗 값 정하기
        int pivot = (start + end) / 2;
        int pivotNum = arr[pivot];

        // 양쪽 포인트 정하기
        int left = start;
        int right = end;

        // left <= right 까지 반복
        while (left <= right){
            // left의 값이 피벗 값보다 작으면 지나감
            while (arr[left] < pivotNum) left++;

            // right의 값이 피벗 값보다 크면 지나감
            while (arr[right] > pivotNum) right--;

            // left <= right면 swap
            if (left <= right){
                swap(left, right);
                left++;
                right--;
            }
        }

        // 나눠진 부분 퀵소트
        quickSort(start, right);
        quickSort(left, end);
    }

    private static void swap(int left, int right){
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
