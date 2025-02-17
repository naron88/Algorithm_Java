class Solution {
    public int[] runningSum(int[] nums) {
        int length = nums.length; 
        int[] result = new int[length];
        
        // 첫 값 넣기
        result[0] = nums[0];
        // 나머지 넣기
        for (int i = 1; i < length; i++) {
            result[i] = result[i-1] + nums[i];
        }
        
        return result;
    }
}
