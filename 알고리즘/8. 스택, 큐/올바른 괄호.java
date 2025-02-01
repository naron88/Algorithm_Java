import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        char[] toChar = s.toCharArray();
        Deque<Character> charStack = new LinkedList<>();
        
        for (int i = 0; i < toChar.length; i++){
            // '(' 일 경우 스택에 넣기
            if (toChar[i] == '('){
                charStack.offerLast('(');
            }
            // ')' 일 경우 스택에서 빼기 / 스택이 비어있으면 false
            else {
                if (charStack.isEmpty()){
                    answer = false;
                } else{
                    charStack.pollLast();
                }
            }
        }
        
        // 스택이 비어있지 않으면 false
        if (!charStack.isEmpty()){
            answer = false;
        }

        return answer;
    }
}
