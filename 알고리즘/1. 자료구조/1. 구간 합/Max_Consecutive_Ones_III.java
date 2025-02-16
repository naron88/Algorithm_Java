class Solution {
    public int longestOnes(int[] nums, int k) {
        // 0을 1로 전환할 때 +1
        int knum = 0;
        // left, right 포인터
        int left = 0;
        int right = 0;
        // 결과
        int max = 0;
        int subArray = 0;
        
        // right가 legth 전까지 반복
        while (right < nums.length){
            // 값이 0일 경우
            if (nums[right] == 0) {
                // knum이 k와 같을 경우
                if (knum == k) {
                    // left 값에 따라
                    if (nums[left] == 0) {
                        knum--;
                        subArray--;
                        left++;
                    }
                    else {
                        subArray--;
                        left++;
                    }
                }
    
                // knum이 k보다 작을 경우
                else {
                    // knum++, right++
                    subArray++;
                    knum++;
                    right++;
                }
            }
            
            // 값이 1일 경우
            else {
                // subArray에 추가, right++
                subArray++;
                right++;
                
            }
            if (max < subArray) {
                max = subArray;
            }
        }
        return max;
    }
}
