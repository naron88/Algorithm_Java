class Solution {
    public int waysToSplitArray(int[] nums) {
        // 구간합
        // i번째 인덱스인 경우: prefix[i] 와 prefix[length - 1] - prefix[i] 비교

        long[] prefix = new long[nums.length + 1];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i-1] + nums[i-1];
        }

        int count = 0;

        for (int i = 1; i < prefix.length - 1; i++) {
            if (prefix[i] >= prefix[prefix.length - 1] - prefix[i]) {
                count++;
            }
        }

        return count;
    }
}
