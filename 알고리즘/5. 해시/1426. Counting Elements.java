class Solution {
    public int countElements(int[] arr) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int count = 0;
        for (int i : arr) {
            // 없으면 1을 저장, 있으면 + 1
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
        }
        // key만큼 반복
        for (int i : hashMap.keySet()) {
            if (hashMap.containsKey(i + 1)) {
                count += hashMap.get(i);
            }
        }
        return count;
    }
}
