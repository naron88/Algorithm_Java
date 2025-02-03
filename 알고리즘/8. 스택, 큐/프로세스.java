import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        // 큐, 우선순위 큐 준비
        Queue<Node> queue = new LinkedList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        
        // 큐, 우선순위 큐에 넣기
        for (int i = 0; i < priorities.length; i++){
            queue.offer(new Node(priorities[i], i));
            priorityQueue.offer(priorities[i]);
        }
        // 우선순위 큐가 빌 때까지 반복
        int count = 0;
        while(!priorityQueue.isEmpty()){
            // 큐에서 poll후 우선순위 큐와 같은지 확인
            Node process = queue.poll();
            if (process.prior == priorityQueue.peek()){
                // 같으면 우선순위 큐도 빼고 count++
                priorityQueue.poll();
                count++;
                // location과 같으면 반환
                if (process.index == location){
                    return count;
                }
            } else{
                // 우선순위 큐와 다르면 큐에 offer
                queue.offer(process);
            }
        }
        return -1;
    }
    public class Node{
        int prior;
        int index;
        
        public Node(int prior, int index){
            this.prior = prior;
            this.index = index;
        }
    }
}
