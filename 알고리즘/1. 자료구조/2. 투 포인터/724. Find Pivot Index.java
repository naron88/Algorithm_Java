class Solution {
    public int pivotIndex(int[] nums) {
        // 전체 합
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            // right합 = 구간 합 - left - nums[i]
            int right = sum - left - nums[i];

            // 같으면 i 리턴
            if (right == left) return i;

            // left 에 한개씩 넣기
            left += nums[i];
        }
        // 없으면 -1 리턴
        return -1;
    }
}
