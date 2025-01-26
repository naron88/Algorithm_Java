import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 카드 묶음 수 N 입력받기
        int N = Integer.parseInt(st.nextToken());

        // N번의 카드 크기 입력 받기
        PriorityQueue<Integer> cards = new PriorityQueue<>();
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            cards.offer(Integer.parseInt(st.nextToken()));
        }
        // 작은 수 두개 합치기
        int sum = 0;
        while (cards.size() > 1){
            int frag = cards.poll() + cards.poll();
            cards.offer(frag);
            sum += frag;
        }
        System.out.println(sum);
    }
}
