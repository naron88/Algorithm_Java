import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>(); // 해시 맵 선언 (누적 합 빈도 저장)
        counts.put(0, 1); // 초기 상태: 누적 합이 0인 경우를 1개 저장

        int ans = 0; // 정답(부분 배열 개수)
        int curr = 0; // 현재까지의 누적 합

        for (int num: nums) {
            curr += num; // 현재 숫자를 누적 합에 더함
            ans += counts.getOrDefault(curr - k, 0); // curr - k 값이 있는지 확인하여 정답에 추가
            counts.put(curr, counts.getOrDefault(curr, 0) + 1); // 현재 누적 합을 해시 맵에 저장
        }

        return ans; // 최종 결과 반환
    }
}
