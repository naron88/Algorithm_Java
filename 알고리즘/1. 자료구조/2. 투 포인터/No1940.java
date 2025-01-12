import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int start = 0;
        int end = 0;
        int count = 0;

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        for (int i = 0; i < N-1; i++) {
            start = arr[i];
            for (int j = i+1; j < N; j++) {
                end = arr[j];
                if (start + end == M){
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
