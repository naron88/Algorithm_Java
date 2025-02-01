import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++){
            // 배포 완료 시점을 큐에 넣기
            int progressTime = (int)Math.ceil((100.0 - progresses[i]) / speeds[i]);
            queue.offer(progressTime);
        }
        while (!queue.isEmpty()){
            int progressCount = 1;
            int progress = queue.poll();
            while (!queue.isEmpty() && queue.peek() <= progress){
                queue.poll();
                progressCount++;
            }
            result.add(progressCount);
        }
        return result.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}