import java.io.*;
import java.util.*;

public class No1260 {
    // DFS와 BFS 프로그램
    // 1260
    static List<Integer>[] graph;
    static boolean[] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 노드 개수, 에지 개수, 시작점 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        // 그래프 생성 및 초기화
        graph = new LinkedList[node + 1];
        for(int i = 0; i < node + 1; i++){
            graph[i] = new LinkedList<>();
        }

        // 에지 입력받기
        for(int i = 0; i < edge; i++){
            st = new StringTokenizer(br.readLine());
            int edgeStart = Integer.parseInt(st.nextToken());
            int edgeEnd = Integer.parseInt(st.nextToken());
            graph[edgeStart].add(edgeEnd);
            graph[edgeEnd].add(edgeStart);
        }

        // 배열 정렬
        for(int i = 1; i < node + 1; i++){
            Collections.sort(graph[i]);
        }

        visited = new boolean[node + 1];
        DFS(start);
        bw.newLine();

        visited = new boolean[node + 1];
        BFS(start);
        bw.flush();
        bw.close();
    }

    public static void DFS(int start) throws IOException {
        bw.write(start + " ");
        visited[start] = true;

        for(int i : graph[start]){
            if(!visited[i]){
                DFS(i);
            }
        }
    }

    public static void BFS(int start) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();
            bw.write(now + " ");
            for(int i : graph[now]){
                if(!visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}