package _05_해시;
import java.util.*;

class 완주하지_못한_선수 {
    public String solution(String[] participant, String[] completion) {
        // participant: 참가자
        // completion: 완주자
        // 완주 못한 선수의 이름을 return

        Map<String, Integer> retire = new HashMap<>();

        for (String s : participant){
            retire.put(s, retire.getOrDefault(s, 0) + 1);
        }
        // completion 배열로 map 업데이트
        for (String c : completion) {
            retire.put(c, retire.get(c) - 1);
        }

        // 값이 1인 키를 반환
        for (Map.Entry<String, Integer> entry : retire.entrySet()) {
            if (entry.getValue() > 0) {
                return entry.getKey();
            }
        }
        return "";
    }
}