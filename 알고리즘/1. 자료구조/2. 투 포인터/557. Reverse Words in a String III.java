class Solution {
    public String reverseWords(String s) {
        String[] strArr = s.split(" ");
        StringBuilder result = new StringBuilder();

        Deque<Character> stack = new LinkedList<>();

        for (String str : strArr) {
            char[] charArr = str.toCharArray();
            for (char c : charArr) {
                stack.addFirst(c);
            }
            for (char c : charArr) {
                result.append(stack.removeFirst());
            }
            result.append(" ");
        }
        result.deleteCharAt(s.length());
        return result.toString();
    }
}
