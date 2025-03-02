class Solution {
    public String reverseOnlyLetters(String s) {
        // 문자가 아니면 건너뛰기
        int left = 0, right = s.length() - 1;
        char[] result = s.toCharArray();

        while (left < right) {
            while (left < right && !Character.isLetter(result[left])) left++;
            while (left < right && !Character.isLetter(result[right])) right--;

            char tmp = result[left];
            result[left] = result[right];
            result[right] = tmp;
            left++; 
            right--;
        }
        return new String(result);
    }
}
