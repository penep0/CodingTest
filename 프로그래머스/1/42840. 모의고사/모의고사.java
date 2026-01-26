import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = new int[3];
        ArrayList<Integer> ans = new ArrayList<>();
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        for (int i : answers) {
            if (a[countA] == i) answer[0]++;
            if (b[countB] == i) answer[1]++;
            if (c[countC] == i) answer[2]++;
            countA++;
            countA %= 5;
            countB++;
            countB %= 8;
            countC++;
            countC %= 10;
        }
        
        int max = 0;
        int index = -1;
        for (int i = 0; i < 3; i++) {
            if (max < answer[i]) {
                max = answer[i];
                ans.clear();
                ans.add(i + 1);
            } else if (max == answer[i]) {
                ans.add(i + 1);
            }
        }
        
        int[] mem = new int[ans.size()];
        
        for (int i = 0; i < ans.size(); i++) {
            mem[i] = ans.get(i);
        }
        
        return mem;
    }
}