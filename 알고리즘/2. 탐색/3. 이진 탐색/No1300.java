import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        long start = 1;
        long end = k;
        long result = 0;
        while (start <= end){
            long mid = (start + end) / 2;
            long sum = 0;
            for (int i = 1; i <= N; i++) {
                long count = mid / i;
                if (count > N){
                    count = N;
                }
                sum += count;
            }
            if (sum < k){
                start = mid + 1;
            } else {
                result = mid;
                end = mid -1;
            }
        }
        bw.write(result + "");
        bw.flush();
        bw.close();
    }
}
