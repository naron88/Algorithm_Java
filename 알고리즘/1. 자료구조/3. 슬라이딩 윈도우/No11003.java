import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class No11003 {
    public static void main(String[] args) throws IOException {
        // 최솟값 찾기 1
        // 11003
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N개의 숫자 개수, L:슬라이딩 윈도우 크기가 주어짐
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int windowSize = Integer.parseInt(st.nextToken());

        // 리스트 생성
        LinkedList<Node> list = new LinkedList<>();

        // 수 입력받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());

            // 리스트가 비어있지않고, 마지막 value 값이 더 작으면 제거
            while (!list.isEmpty() && list.getLast().value > num){
                list.removeLast();
            }
            // 추가
            list.addLast(new Node(num, i));

            // 첫번째 index가 윈도우 크기 밖에 나가면 제거
            if (list.getFirst().index <= i - windowSize){
                list.removeFirst();
            }
            bw.write(list.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }
    static class Node{
        int value;
        int index;

        Node(int value, int index){
            this.value = value;
            this.index = index;
        }
    }
}