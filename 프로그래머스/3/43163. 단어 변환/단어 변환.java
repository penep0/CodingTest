import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        answer = bfs(begin, target, words);
        return answer;
    }
    
    public int bfs(String word, String target, String[] words) {
        Deque<Integer> distance = new ArrayDeque<>();
        Deque<String> s = new ArrayDeque<>();
        boolean[] visited = new boolean[words.length];
        
        s.add(word);
        distance.add(0);
        while(!s.isEmpty()) {
            String thisWord = s.poll();
            int dist = distance.poll();
            if (thisWord.equals(target)) return dist;
            for (int i = 0; i < words.length; i++) {
                if (checkWord(thisWord, words[i]) && !visited[i]) {
                    distance.add(dist + 1);
                    s.add(words[i]);
                    visited[i] = true;
                }
            }
        }
        
        return 0;
    }
    
    public boolean checkWord(String word, String target) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (target.charAt(i) != word.charAt(i)) count++;
        }
        
        return count == 1 ? true : false;
    }
}