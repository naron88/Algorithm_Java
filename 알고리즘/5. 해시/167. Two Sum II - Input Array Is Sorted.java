class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // 수를 저장하는 해시맵, 인덱스 생성
        Map<Integer, Integer> hashMap = new HashMap<>();
        int index = 0;

        // 배열을 순환하며 target - num이 있을 경우 인덱스 반환, 저장
        for (int num : numbers) {
            index++;
            if (hashMap.containsKey(target - num)) {
                return new int[] {hashMap.get(target - num), index};
            }
            hashMap.put(num, index);
        }
        return new int[0];
    }
}
