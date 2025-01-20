import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(0, N - 1);
        bw.write(arr[K - 1] + "");
        bw.flush();
        bw.close();
    }

    private static void quickSort(int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = (start + end) / 2;
        int pivotValue = arr[pivot];
        int left = start;
        int right = end;
        
        while (left <= right) {
            while (arr[left] < pivotValue) {
                left++;
            }
            while (arr[right] > pivotValue) {
                right--;
            }
            if (left <= right) {
                swap(left, right);
                left++;
                right--;
            }
        }
        quickSort(start, right);
        quickSort(left, end);
    }

    private static void swap(int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}
