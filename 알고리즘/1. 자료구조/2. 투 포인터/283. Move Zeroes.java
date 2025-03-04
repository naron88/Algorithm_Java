class Solution {
    public void moveZeroes(int[] nums) {
        // left, right 포인터
        int left = 0;
        int right = 0;
        // 0이 아닌 값 앞으로 옮기기
        for (right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                nums[left] = nums[right];
                left++;
            }
        }
        // 나머지 0으로 채우기
        while (left < nums.length) {
            nums[left] = 0;
            left++;
        }
    }
}
