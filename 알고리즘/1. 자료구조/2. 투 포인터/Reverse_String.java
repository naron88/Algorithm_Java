class Solution {
    public void reverseString(char[] s) {
        // 양쪽 포인터를 사용해 left <= right까지 반복해서 교환
        int left = 0;
        int right = s.length - 1;
        
        while (left <= right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            
            left++;
            right--;
        }
    }
}
