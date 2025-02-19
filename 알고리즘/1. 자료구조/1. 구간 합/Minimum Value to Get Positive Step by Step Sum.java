
class Solution {
    public int minStartValue(int[] nums) {
        // 결과값, 구간합 값
        int result = nums[0];
        int prefix = nums[0];
        // num의 길이만큼 반복해서 구간합 값에 넣기
        for (int i = 1; i < nums.length; i++){
            prefix = nums[i] + prefix;
            // 가장 작은 값을 결과값에 넣기
            if (result > prefix) {
                result = prefix;
            }
        }
        // 가장 작은 값이 음수면 -1을 곱하고 +1
        if (result <= 0) {
            result = Math.abs(result) + 1;
        }
        else {
            // 양수면 1
            result = 1;
        }
        return result;
        
    }
}
