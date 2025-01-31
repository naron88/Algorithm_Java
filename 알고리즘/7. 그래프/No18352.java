import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 도시 개수, 도로 개수, 거리 정보, 출발 도시 정보 입력받기
        int cityNumber = Integer.parseInt(st.nextToken());
        int streetNumber = Integer.parseInt(st.nextToken());
        int streetInfo = Integer.parseInt(st.nextToken());
        int startCity = Integer.parseInt(st.nextToken());
        // 도로 개수만큼 단방향 입력 받기
        Map<Integer, List<Integer>> cityMap = new HashMap<>();
        for (int i = 1; i <= cityNumber; i++){
            cityMap.put(i, new LinkedList<>());
        }
        for (int i = 0; i < streetNumber; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            cityMap.get(start).add(end);
        }
        // 최단 거리 계산
        Set<Integer> result = new TreeSet<>();
        int[] visited = new int[cityNumber+1];
        Arrays.fill(visited, -1);

        Queue<Integer> cityQueue = new LinkedList<>();
        visited[startCity]++;
        cityQueue.offer(startCity);
        while (!cityQueue.isEmpty()){
            int num = cityQueue.poll();
            for (int i : cityMap.get(num)){
                if (visited[i] == -1) {
                    visited[i] = visited[num] + 1;
                    cityQueue.offer(i);
                }
            }
        }

        for (int i = 0; i <= cityNumber; i++){
            if (visited[i] == streetInfo){
                result.add(i);
            }
        }
        if (result.isEmpty()){
            System.out.println(-1);
        } else{
            for (int n : result){
                System.out.println(n);
            }
        }
    }
}