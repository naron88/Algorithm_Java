import java.io.*;
import java.util.*;

public class Main {
    public static boolean[] visited;
    public static Map<Integer, List<Integer>> group;
    public static int valid;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. 사람의 수, 친구 관계 수 입력 받기
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 2. 관계 입력 받기
        group = new HashMap<>();
        for (int i = 0; i < N; i++){
            group.put(i, new LinkedList<>());
        }

        // 3. 관계 입력 받기
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            group.get(from).add(to);
            group.get(to).add(from);
        }

        // 4. 5번째까지 연결되어있는지 확인
        valid = 0;
        visited = new boolean[N];
        for (int i = 0; i < N; i++){
            DFS(i, 1);

        }
        bw.write(String.valueOf(valid));
        bw.flush();
        bw.close();
    }

    public static void DFS(int i, int count){
        // 왼료되었으면 return;
        if (count == 5 || valid == 1){
            valid = 1;
            return;
        }
        // 방문했었으면 종료
        if (visited[i]) return;
        // 방문하기
        visited[i] = true;
        // 앳지 방문하기
        for (int n : group.get(i)){
            if (!visited[n]) {
                DFS(n, count + 1);
            }
        }
        // 끝나면 초기화
        visited[i] = false;
    }
}
