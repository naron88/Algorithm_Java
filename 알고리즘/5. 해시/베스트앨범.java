import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 1. 장르별 총 재생 수를 저장할 Map
        Map<String, Integer> genrePlayCount = new HashMap<>();

        // 2. 장르별 곡 정보 저장 (재생 수, 고유 번호)
        Map<String, List<int[]>> genreSongs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            // 장르별 총 재생 수 계산
            genrePlayCount.put(genres[i], genrePlayCount.getOrDefault(genres[i], 0) + plays[i]);

            // 장르별 곡 정보 저장
            genreSongs.putIfAbsent(genres[i], new ArrayList<>());
            genreSongs.get(genres[i]).add(new int[]{plays[i], i});
        }

        // 3. 장르별 총 재생 수를 기준으로 정렬
        List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        sortedGenres.sort((g1, g2) -> genrePlayCount.get(g2) - genrePlayCount.get(g1));

        // 4. 각 장르에서 가장 많이 재생된 곡 2개 선택
        List<Integer> result = new ArrayList<>();
        for (String genre : sortedGenres) {
            List<int[]> songs = genreSongs.get(genre);

            // 재생 수 기준 내림차순, 재생 수 같으면 고유번호 기준 오름차순 정렬
            songs.sort((s1, s2) -> s1[0] == s2[0] ? s1[1] - s2[1] : s2[0] - s1[0]);

            // 최대 2곡 선택
            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                result.add(songs.get(i)[1]);
            }
        }
        int[] resultArray = result.stream().mapToInt(i -> i).toArray();
        return resultArray;
    }
}
