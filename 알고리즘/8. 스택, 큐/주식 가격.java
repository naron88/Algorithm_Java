import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        Deque<Integer> priceStack = new LinkedList<>();
        int[] result = new int[prices.length];
        // 주식 개수만큼 반복
        for (int i = 0; i < prices.length; i++){
            // 비어있지 않고 이전 값이 더 클경우 스택에서 빼고 초 세기
            while (!priceStack.isEmpty() && prices[priceStack.peekLast()] > prices[i]){
                int pollPriceIndex = priceStack.pollLast();
                result[pollPriceIndex] = i - pollPriceIndex;
            }
            // 스택에 넣기
            priceStack.offerLast(i);
        }
        // 스택이 빌 때까지 반복해서 초 세기
        while (!priceStack.isEmpty()){
            int pollPriceIndex = priceStack.pollLast();
            result[pollPriceIndex] = prices.length - pollPriceIndex - 1;
        }
        return result;
    }
}
