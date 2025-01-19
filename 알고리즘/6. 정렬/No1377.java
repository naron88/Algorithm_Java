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

        Node[] arr = new Node[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            arr[i] = new Node(i, num);
        }

        Arrays.sort(arr);

        int max = 0;
        for (int i = 0; i < N; i++) {
            // 정렬 후 - 정렬 전 인덱스
            // 왼쪽에서 오른쪽으로 스왑 횟수의 최대값
            if (max < arr[i].index - i){
                max = arr[i].index - i;
            }
        }

        // 스왑이 일어나지 않은 i를 출력하기 때문에 +1
        bw.write(max+1 + "");
        bw.flush();
        bw.close();
    }

    public static class Node implements Comparable<Node>{
        int index;
        int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            // 오름차순 정렬
            return Integer.compare(this.value, o.value);
        }
    }
}
