class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> losses = new HashMap<>();
        Set<Integer> players = new HashSet<>();

        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];

            // 승자, 패자 모두 "플레이어로 참여한 것"이므로 기록
            players.add(winner);
            players.add(loser);

            // 패자는 패배 카운트 증가
            losses.put(loser, losses.getOrDefault(loser, 0) + 1);
        }

        List<Integer> noLoss = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();

        for (int player : players) {
            int lossCount = losses.getOrDefault(player, 0);
            if (lossCount == 0) {
                noLoss.add(player);
            } else if (lossCount == 1) {
                oneLoss.add(player);
            }
        }

        // 오름차순 정렬
        Collections.sort(noLoss);
        Collections.sort(oneLoss);

        return List.of(noLoss, oneLoss);
    }
}
