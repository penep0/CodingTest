import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        
        for (String cmd : operations) {
            StringTokenizer st = new StringTokenizer(cmd);
            if (st.nextToken().equals("I")) {
                int num = Integer.parseInt(st.nextToken());
                tm.put(num, tm.getOrDefault(num, 0) + 1);
            } else if (!tm.isEmpty()) {
                if (st.nextToken().equals("1")) {
                    tm.replace(tm.lastKey(), tm.get(tm.lastKey()) - 1);
                    if (tm.get(tm.lastKey()) == 0) tm.remove(tm.lastKey());
                } else {
                    tm.replace(tm.firstKey(), tm.get(tm.firstKey()) - 1);
                    if (tm.get(tm.firstKey()) == 0) tm.remove(tm.firstKey());
                }
            }
        }
        
        if (tm.isEmpty()) {
            return new int[] {0, 0};
        }
        answer[0] = tm.lastKey();
        answer[1] = tm.firstKey();
        return answer;
    }
}