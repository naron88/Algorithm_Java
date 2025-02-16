class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int maxSubArrays = 0;
        int subArrays = 0;
        int left = 0;
        int right = 0;
        for (right = 0; right < k; right++) {
            subArrays += nums[right];
            maxSubArrays = subArrays;
        }
        while (right < nums.length) {
            subArrays += nums[right];
            right++;
            
            subArrays -= nums[left];
            left++;
            
            if (maxSubArrays < subArrays) {
                maxSubArrays = subArrays;
            }
        }
        double maxAvg = (double) maxSubArrays / k;
        return maxAvg;
    }
}
