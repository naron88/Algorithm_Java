class Solution {
    public int[] getAverages(int[] nums, int k) {
        int length = nums.length;
        // 구간 합 배열 생성
        long[] prefixNums = new long[length];
        prefixNums[0] = nums[0];
        for (int i = 1; i < length; i++) {
            prefixNums[i] = prefixNums[i - 1] + nums[i]; 
        }
        // 결과 배열 생성
        int[] resultNums = new int[length];
        // 배열 길이만큼 반복
        for (int i = 0; i < length; i++){
            // prefix[i+k] - prefix[i-k-1]
            int right = i + k;
            int left = i - k;
            // 인덱스가 0보다 작거나 배열 길이보다 크면 결과 배열에 -1 삽입
            if (left < 0 || right >= length) {
                resultNums[i] = -1;
            }
            // 위가 아니면 구간 합을 2k+1로 나눠서 넣기
            else {
                if (left == 0) {
                    resultNums[i] = (int)(prefixNums[right] / (2 * k + 1));
                }
                else {
                    resultNums[i] = (int)((prefixNums[right] - prefixNums[left - 1]) / (2 * k + 1));
                }
            }
        }
        return resultNums;
    }
}
