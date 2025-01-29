import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int countOne = 0;

        PriorityQueue<Integer> plusNumbers = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusNumbers = new PriorityQueue<>();
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if (num > 1) plusNumbers.offer(num);
            else if (num < 1) minusNumbers.offer(num);
            else countOne++;
        }

        int plusSum = getSum(plusNumbers);;
        int minusSum = getSum(minusNumbers);
        System.out.println(plusSum + minusSum + countOne);
    }

    private static int getSum(PriorityQueue<Integer> numbers) {
        int sum = 0;
        while (numbers.size() > 1){
            int frag = numbers.poll() * numbers.poll();
            sum += frag;
        }
        if (!numbers.isEmpty()){
            sum += numbers.poll();
        }
        return sum;
    }
}
