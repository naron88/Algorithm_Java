import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class No11724 {
    // 연결 오소 개수
    // 11724
    private static LinkedList<Integer>[] graph;
    private static boolean[] visited;

    // DFS 함수 구현
    public static void DFS(int start){
        // 이미 방문했을 경우 = 종료
        if(visited[start]) {
            return;
        }

        // 노드에 방문했으므로 true
        visited[start] = true;

        // 그래프에 있는 노드가 끝날 때까지 반복
        for (int i : graph[start]){
            if (!visited[i]){
                DFS(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n(노드 수), m(에지 수) 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new LinkedList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < m; i++) {
            // 시작 노드, 끝 노드 입력 받기
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }
        int count = 0;
        for (int i = 1; i < n + 1; i++) {
            if(!visited[i]){
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }
}
