class Solution {
    public int maxVowels(String s, int k) {
        // 슬라이딩 윈도우 크기: K
        // 모음의 최대 개수 반환

        // 모음이 들어올때 +1, 나갈때 -1
        
        int left = 0;
        int right = 0;
        int count = 0;
        // k개 넣기
        for (right = 0; right < k; right++) {
            char ch = s.charAt(right);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        int max = count;
        for (right = k; right < s.length(); right++) {
            char ch1 = s.charAt(right);
            if(ch1 == 'a' || ch1 == 'e' || ch1 == 'i' || ch1 == 'o' || ch1 == 'u') {
                count++;
            }
            char ch2 = s.charAt(left);
            if(ch2 == 'a' || ch2 == 'e' || ch2 == 'i' || ch2 == 'o' || ch2 == 'u') {
                count--;
            }
            left++;
            max = Math.max(max, count);
        }
        return max;
    }
}
