class Solution {
    public boolean isSubsequence(String s, String t) {
        // sPoint, tPoint = 0;
        int sPoint = 0;
        int tPoint = 0;
    
        // s 길이 만큼 반복
        while (sPoint < s.length()){
            // tPoint가 t의 길이보다 길면 false
            if (tPoint >= t.length()) return false;
            // t와 같지않으면 tPoint++
            if (s.charAt(sPoint) != t.charAt(tPoint)) {
                tPoint++;
            }
            // s와 t가 같으면 tPoint++ , sPoint++
            else {
                tPoint++;
                sPoint++;
            }
        }
        return true;
    }
}
