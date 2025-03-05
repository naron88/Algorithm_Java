class Solution {
    public String reversePrefix(String word, char ch) {
        // 인덱스 지정, string Bulider 생성
        int left = -1;
        int right = -1;
        StringBuilder result = new StringBuilder();
        // word를 char 배열로 바꾸기
        char[] charArr = word.toCharArray();

        // ch와 같은 값 찾기
        for (int i = 0; i < charArr.length; i++){
            // 값 인덱스를 left, right에 넣기
            if (charArr[i] == ch) {
                left = i;
                right = i+1;
                break;
            }
        }
            
        // left가 -1 이면 word를 return
        if (left == -1) return word;

        // left-- 하면서 값 넣기
        while (left >= 0) {
            result.append(charArr[left]);
            left--;
        }
        // rigth++ 하면서 값 넣기
        while (right < charArr.length) {
            result.append(charArr[right]);
            right++;
        }

        // return 
        return result.toString();
    }
}
