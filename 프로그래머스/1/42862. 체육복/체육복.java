import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        ArrayList<Integer> lostList = new ArrayList<>();
        ArrayList<Integer> reserveList = new ArrayList<>();
        
        for (int i : lost) lostList.add(i);
        for (int i : reserve) reserveList.add(i);
        
        for (int i = 0; i < reserveList.size(); i++) {
            int r = reserveList.get(i);
            if (lostList.contains(r)) {
                lostList.remove(Integer.valueOf(r));
                reserveList.remove(i);
                i--;
            }
        }
        
        for (int i : reserveList) {
            if (lostList.contains(i - 1)) {
                lostList.remove(Integer.valueOf(i - 1));
            } else if (lostList.contains(i + 1)) {
                lostList.remove(Integer.valueOf(i + 1));
            }
        }
        
        return n - lostList.size();
    }
}