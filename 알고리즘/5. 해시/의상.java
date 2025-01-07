package _05_해시;
import java.util.*;

class 의상 {
    public int solution(String[][] clothes) {
        // 키 값당 곱하기
        // 1개만 입는 경우 : 값의 합
        // 2개만 입는 경우 : 2개를 곱한 값들의 합 ...

        int answer = 1;
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1] , 0) + 1);
        }


        for (Map.Entry<String, Integer> entry : map.entrySet()){
            answer *= entry.getValue() + 1;
        }

        return answer - 1;
    }
}
