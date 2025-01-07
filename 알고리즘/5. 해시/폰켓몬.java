package _05_해시;

import java.util.*;

public class 폰켓몬 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 4, 3};
        int result = solution(nums);
        System.out.println(result);
    }

    private static int solution(int[] nums) {
        // N개의 포켓몬중 N/2만 가져갈 수 있음
        // 그 중 최대한 많은 종류의 포켓몬을 가져가고 싶음
        // 가장 많은 종류의 폰켓몬을 선택하는 방법
        Set<Integer> resultSet = new HashSet<>();
        for (int i : nums){
            resultSet.add(i);
        }
        int answer;
        if (nums.length / 2 < resultSet.size()){
            answer = nums.length / 2;
        }else{
            answer = resultSet.size();
        }
        return answer;
    }
}
