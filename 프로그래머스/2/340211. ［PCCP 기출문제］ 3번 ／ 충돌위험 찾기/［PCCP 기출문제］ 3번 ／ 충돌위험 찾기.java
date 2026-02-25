import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        List<List<int[]>> route = new ArrayList<>();
        
        for (int i = 0; i < routes.length; i++) {
            int x = points[routes[i][0] - 1][0];
            int y = points[routes[i][0] - 1][1];
            
            List<int[]> record = new ArrayList<>();
            record.add(new int[]{x, y});
            
            for (int k = 1; k < routes[i].length; k++) {
                int ex = points[routes[i][k] - 1][0];
                int ey = points[routes[i][k] - 1][1];

                while (x != ex || y != ey) {
                    if (x > ex) x--;
                    else if (x < ex) x++;
                    else if (y > ey) y--;
                    else if (y < ey) y++;

                    record.add(new int[]{x, y});
                }
            }
            
            route.add(record);
        }
        
        int maxTime = 0;
        for (List<int[]> path : route) maxTime = Math.max(maxTime, path.size());

        for (int t = 0; t < maxTime; t++) {
            Map<String, Integer> map = new HashMap<>();

            for (List<int[]> path : route) {
                if (t >= path.size()) continue;
                int[] pos = path.get(t);
                String key = pos[0] + "," + pos[1];
                map.put(key, map.getOrDefault(key, 0) + 1);
            }

            for (int count : map.values()) {
                if (count >= 2) answer++;
            }
        }

        return answer;
    }
}