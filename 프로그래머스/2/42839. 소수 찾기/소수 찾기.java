import java.util.*;

class Solution {
    static StringBuilder sb;
    static boolean[] check;
    static HashSet<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        sb = new StringBuilder();
        check = new boolean[numbers.length()];
        back(0, numbers.length(), numbers);
        return set.size();
    }
    
    public void back(int count, int size, String numbers) {
        for (int i = 0; i < size; i++) {
            if (!check[i]){
                check[i] = true;
                sb.append(numbers.charAt(i));
                if (isPrimeNumber(Integer.parseInt(sb.toString()))){
                    set.add(Integer.parseInt(sb.toString()));
                }
                back(count + 1, size, numbers);
                sb.deleteCharAt(sb.length() - 1);
                check[i] = false;
            }
        }
    }
    
    public boolean isPrimeNumber(int a) {
        if (a == 1 || a == 0) return false;
        for (int i = 2; i < a; i++) {
            if (a % i == 0) return false;
        }
        return true;
    }
}