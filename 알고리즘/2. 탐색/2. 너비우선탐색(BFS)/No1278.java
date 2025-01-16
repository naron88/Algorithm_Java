import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static boolean visited[][];
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static int N;
    public static int M;
    public static int[][] miro;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        miro = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            for (int j = 0; j < M; j++) {
                miro[i][j] = Integer.parseInt(s.substring(j, j + 1));
            }
        }
        BFS(0, 0);
        bw.write(miro[N - 1][M - 1] + "");
        bw.flush();
        bw.close();
    }

    public static void BFS(int i, int j) {
        Deque<int[]> queue = new LinkedList<>();
        queue.offerLast(new int[]{i, j});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.pollFirst();
            for (int k = 0; k < 4; k++) {
                // 4 방향 반복
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];

                // 좌표가 틀 안에 있는 경우
                if (x >= 0 && y >= 0 && x < N && y < M) {
                    // 0이면 못지나감
                    if (miro[x][y] != 0 && !visited[x][y]) {
                        visited[x][y] = true;
                        // depth 증가
                        miro[x][y] = miro[now[0]][now[1]] + 1;
                        queue.offerLast(new int[]{x, y});
                    }
                }
            }
        }
    }
}
