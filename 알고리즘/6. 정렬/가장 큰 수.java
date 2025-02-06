import java.util.*;

public class Solution {
    public String solution(int[] numbers) {
        // 숫자 배열을 문자열 배열로 변환
        String[] strNumbers = Arrays.stream(numbers)
                                     .mapToObj(String::valueOf) 
                                     .toArray(String[]::new);

        // 커스텀 비교자 사용: 두 문자열을 합친 값을 비교
        Arrays.sort(strNumbers, (a, b) -> (b + a).compareTo(a + b));

        // 정렬된 배열을 합쳐서 가장 큰 수 생성
        String result = String.join("", strNumbers);

        // "0"이 여러 개일 경우 "0"을 하나만 반환
        if (result.charAt(0) == '0') {
            return "0";
        }

        return result;
    }
}
