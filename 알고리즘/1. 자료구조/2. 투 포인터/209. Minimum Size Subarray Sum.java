class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // left, right
        int left = 0;
        int right = 0;
        // subArr, minLength
        int subArr = 0;
        int minLength = 100001;

        for (right = 0; right < nums.length; right++) {
            subArr += nums[right];

            while (subArr >= target) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                }
                subArr -= nums[left];
                left++;
            }
        }
        if (minLength == 100001) return 0;
        else return minLength;
    }
}
