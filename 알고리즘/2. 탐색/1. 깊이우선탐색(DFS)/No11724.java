import java.io.*;
import java.util.*;

public class Main{
    public static boolean[] visited;
    public static Map<Integer, List<Integer>> graph;
    public static int count;

    public static void DFS(int u){
        if (visited[u]){
            return;
        }
        visited[u] = true;
        for (int i : graph.get(u)){
            DFS(i);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 정점의 개수 N, 간선의 개수 M 받기, 방문 리스트 생성, 요소 개수 생성
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N+1];
        count = 0;
        // M개의 양 끝점 u, v 입력 받기, 방문 리스트 초기화
        graph = new HashMap<>();
        for (int i = 1; i <= N; i++){
            graph.put(i, new LinkedList<>());
            visited[i] = false;
        }
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // DFS
        // N번 반복
        for (int i = 1; i <= N; i++){
            if (!visited[i]){
                count++;
                DFS(i);
            }
        }
        System.out.println(count);
    }
}
