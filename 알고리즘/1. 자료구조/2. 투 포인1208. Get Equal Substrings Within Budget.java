class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        // 아스키 코드의 차 = 코스트
        // 
        int left = 0;
        int right = 0;
        int cost = 0;
        int maxLength = 0;

        while (right < s.length()) {
            cost += Math.abs(s.charAt(right) - t.charAt(right));

            while (cost > maxCost) {
                cost -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return  maxLength;
    }
}
