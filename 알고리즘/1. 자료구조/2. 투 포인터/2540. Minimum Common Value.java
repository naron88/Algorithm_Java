class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        // nums1의 포인터, nums2의 포인터
        int nums1Pointer = 0;
        int nums2Pointer = 0;
        // 포인터가 끝에 갈 때까지 반복
        while(nums1Pointer < nums1.length && nums2Pointer < nums2.length) {
            // 같으면 그 값 리턴
            if (nums1[nums1Pointer] == nums2[nums2Pointer]) {
                return nums1[nums1Pointer];
            }
            // 다르면 작은쪽 포인터++
            else {
                if (nums1[nums1Pointer] < nums2[nums2Pointer]) {
                    nums1Pointer++;
                } else {
                    nums2Pointer++;
                }
            }
        }
           
        // -1 리턴
        return -1;
    }
}
