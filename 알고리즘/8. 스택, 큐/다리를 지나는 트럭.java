import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int bridgeOnTruckWeight = 0;
        int index = 0;
        Queue<Integer> bridge = new LinkedList<>();
        // 큐를 다리 길이만큼 0으로 채우기
        for (int i = 0; i < bridge_length; i++){
            bridge.offer(0);
        }
        // 넣어야하는 트럭 수 또는 다리에 올라간 무게가 0보다 클 때까지 반복
        while (index < truck_weights.length || bridgeOnTruckWeight > 0){
            time++;
            // 큐에서 poll하고 다리에 올라간 무게에서 빼기
            bridgeOnTruckWeight -= bridge.poll();
            // 만약 넣을 트럭이 있고 다리에 올라간 무게와 다음에 올라갈 트럭의 무게 합이 총 무게 이하일 경우 트럭넣기
            if (index < truck_weights.length && bridgeOnTruckWeight + truck_weights[index] <= weight){
                bridge.offer(truck_weights[index]);
                bridgeOnTruckWeight += truck_weights[index];
                index++;
            } else{
                // 아니면 0 넣기
                bridge.offer(0);
            }
        }
        return time;
    }
}
