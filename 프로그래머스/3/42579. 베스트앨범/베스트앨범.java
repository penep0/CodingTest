import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> playCount = new HashMap<>();
        HashMap<String, List<Integer>> music = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            playCount.put(genres[i], playCount.getOrDefault(genres[i], 0) + plays[i]);
            map.put(i, plays[i]);
            music.putIfAbsent(genres[i], new ArrayList<>());
            music.get(genres[i]).add(i);
        }
        
        List<String> list = new ArrayList(playCount.keySet());
        Collections.sort(list, (s1, s2) -> playCount.get(s2) - playCount.get(s1));
        for (String s : list) {
            List<Integer> musicList = music.get(s);
            Collections.sort(musicList, (s1, s2) -> plays[s2] - plays[s1]);
            if (musicList.size() > 1) {
                answer.add(musicList.get(0));
                answer.add(musicList.get(1));
            } else {
                answer.add(musicList.get(0));
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}