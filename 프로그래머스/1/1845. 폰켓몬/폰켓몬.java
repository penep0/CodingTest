import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> hash = new HashSet<>();
        int max = nums.length / 2;
        for(int i : nums) {
            hash.add(i);
        }
        
        if(hash.size() >= max) {
            answer = max;
        }else {
            answer = hash.size();
        }
        
        return answer;
    }
}