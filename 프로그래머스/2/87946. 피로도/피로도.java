import java.util.*;

class Solution {
    static boolean[] check;
    static int answer = 0;
    static ArrayList<Integer> d = new ArrayList<>();
    public int solution(int k, int[][] dungeons) {
        check = new boolean[dungeons.length];
        int hp = k;
        back(0, dungeons, hp);
        return answer;
    }
    
    public static void back(int count, int[][] dungeons, int k) {
        for (int i = 0; i < dungeons.length; i++) {
            if (k < dungeons[i][0]) {
                answer = Math.max(count, answer);
                continue;
            }
            if (!check[i]) {
                check[i] = true;
                back(count + 1, dungeons, k - dungeons[i][1]);
                check[i] = false;
            }
        }
    }
    
}