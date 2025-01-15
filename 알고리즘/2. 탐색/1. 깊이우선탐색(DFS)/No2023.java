import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static BufferedWriter bw;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int[] primes = {2, 3, 5, 7};
        for (int i : primes) {
            DFS(i, 1);
        }
        bw.flush();
        bw.close();
    }

    public static void DFS(int i, int count) throws IOException {
        if (count == n){
            if(isPrime(i)){
                bw.write(String.valueOf(i));
                bw.newLine();
            }
            return;
        }
        for (int j = 1; j <10; j+=2){
            if (isPrime(i * 10 + j)) {
                DFS(i * 10 + j, count + 1);
            }
        }

    }

    public static boolean isPrime(int n){
        for (int i = 2; i <= n/2; i++){
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }
}
